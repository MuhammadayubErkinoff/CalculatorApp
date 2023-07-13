package Panels.Buttons;

import Panels.Function;
import Panels.TextPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorButton extends OrdinaryButton {
    public CalculatorButton(String label, TextPanel textPanel, Function function){
        super(label);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.addFunction(function);
            }
        });
    }
}
