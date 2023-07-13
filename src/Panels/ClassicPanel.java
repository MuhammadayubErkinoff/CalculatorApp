package Panels;

import Panels.Buttons.CalculatorButton;
import Panels.Buttons.NumberButton;
import Panels.Buttons.SpecialButtons.ACButton;
import Panels.Buttons.SpecialButtons.DotButton;
import Panels.Buttons.SpecialButtons.EqualsButton;
import Panels.Buttons.SpecialButtons.TwoZeroesButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClassicPanel extends Panel{
    TextPanel textPanel;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,dt,pl,mn,dv,ml,ac,eq,z2;

    public ClassicPanel(TextPanel textPanel){
        setVisible(true);
        this.textPanel=textPanel;
        setSize(700,200);
        setLayout(new GridLayout(3,1,5,5));
        setBackground(Color.white);
        b0=new NumberButton("0",textPanel);
        b1=new NumberButton("1",textPanel);
        b2=new NumberButton("2",textPanel);
        b3=new NumberButton("3",textPanel);
        b4=new NumberButton("4",textPanel);
        b5=new NumberButton("5",textPanel);
        b6=new NumberButton("6",textPanel);
        b7=new NumberButton("7",textPanel);
        b8=new NumberButton("8",textPanel);
        b9=new NumberButton("9",textPanel);
        dt=new DotButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.makeDecimal();
            }
        });
        pl=new CalculatorButton("+",textPanel, new Function() {
                    @Override
                    public BigDecimal perform(BigDecimal a, BigDecimal b) {
                        return a.add(b);
                    }
        });
        mn=new CalculatorButton("-",textPanel, new Function() {
                    @Override
                    public BigDecimal perform(BigDecimal a, BigDecimal b) {
                        return a.subtract(b);
                    }
        });
        dv=new CalculatorButton("/",textPanel,new Function() {
                    @Override
                    public BigDecimal perform(BigDecimal a, BigDecimal b) {
                        return a.divide(b,100, RoundingMode.HALF_UP);
                    }
        });
        ml=new CalculatorButton("*",textPanel,new Function() {
                    @Override
                    public BigDecimal perform(BigDecimal a, BigDecimal b) {
                        return a.multiply(b);
                    }
        });
        ac=new ACButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.acPressed();
            }
        });
        eq=new EqualsButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.equal();
            }
        });
        z2=new TwoZeroesButton("00", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.numberButtonPressed(0);
                textPanel.numberButtonPressed(0);
            }
        });
        add(b1);
        add(b2);
        add(b3);
        add(b0);
        add(eq);
        add(ac);

        add(b4);
        add(b5);
        add(b6);
        add(z2);
        add(pl);
        add(mn);

        add(b7);
        add(b8);
        add(b9);
        add(dt);
        add(ml);
        add(dv);

    }
}