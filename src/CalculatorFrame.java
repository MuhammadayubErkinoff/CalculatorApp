import Panels.ClassicPanel;
import Panels.TextPanel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorFrame extends Frame {
    CalculatorFrame(){
        setTitle("Scientific Calculator");
        setMinimumSize(new Dimension(700,700));
        setLayout(new GridLayout(2,0));
        TextPanel textPanel=new TextPanel();
        add(textPanel);
        add(new ClassicPanel(textPanel));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
