package Panels;


import java.awt.*;
import java.math.BigDecimal;

public class TextPanel extends Panel {
    private Label l;
    private String s="0";
    private BigDecimal cur=BigDecimal.ZERO;
    private BigDecimal ans=BigDecimal.ZERO;
    private boolean isDec=false;
    private boolean eq=false;
    private BigDecimal dec=BigDecimal.ONE;
    private final Function def=new Function() {
        @Override
        public BigDecimal perform(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    };

    private Function func=def;

    public TextPanel() {
        setVisible(true);
        setSize(700,200);
        setLayout(new GridLayout(3,1,10,0));
        setBackground(Color.white);
        init();
        add(l);
    }

    private void init(){
        l=new Label(s+"   ");
        l.setAlignment(Label.RIGHT);
        l.setFont(new Font("TimesRoman",Font.PLAIN,30));
    }

    private void updateText(){
        l.setText("   "+s);
    }
    public void acPressed(){
        s="0";
        cur=BigDecimal.ZERO;
        ans=BigDecimal.ZERO;
        isDec=false;
        eq=false;
        dec=BigDecimal.ONE;
        updateText();
        func=def;
    }
    public void numberButtonPressed(int dig) {
        if(eq){
            acPressed();
        }
        if (cur.toString().length() < 40) {
            BigDecimal add=new BigDecimal(dig);
            if(!isDec) {
                cur = cur.multiply(BigDecimal.TEN);
                cur = cur.add(add);
            }
            else{
                dec = dec.multiply(BigDecimal.TEN);
                cur=cur.add(add.divide(dec));
            }
            s=cur.toString();
            updateText();
        }
    }
    public void makeDecimal(){
        isDec=true;
    }

    public void equal() {
        if(!eq) {
            eq=true;
            ans = func.perform(ans, cur);
            if(ans.toBigInteger().toString().length()>100){
                acPressed();
                s="Number is too big to represent!";
                updateText();
            }
            else {
                s = represent(ans);
                updateText();
                cur = BigDecimal.ZERO;
                isDec = false;
                dec = BigDecimal.ONE;
            }
        }
    }


    public void addFunction(Function function){
        equal();
        eq=false;
        func=function;
    }

    String represent(BigDecimal a){
        String[]s=a.toString().split("\\.");
        if(s[0].length()>40){
            String cur="";
            StringBuilder ret= new StringBuilder();
            for(int i=1;i<40;i++){
                cur+=s[0].charAt(i);
                if(s[0].charAt(i)!='0'){
                    cur="";
                    ret.append(cur);
                }
            }
            if(ret.length()==0)ret.append("0");
            return s[0].charAt(0)+"."+ret+" e"+(s[0].length()-1);
        }
        if(s.length==1)return s[0];
        if(s[0].equals("0")){
            int zer=1;
            for(int i=0;i<s[1].length();i++){
                if(s[1].charAt(i)=='0')break;
                zer++;
            }
            return s[1].charAt(zer)+"."+s[1].substring(zer+1,Math.min(zer+40,s[1].length()))+" e-"+zer;
        }
        return s[0]+"."+s[1].substring(0,Math.min(40-s[0].length(),s[1].length()));
    }
}
