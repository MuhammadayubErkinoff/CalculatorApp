package Panels.Buttons;

import Panels.TextPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends OrdinaryButton {

    public NumberButton(String label, TextPanel textPanel){
        super(label);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.numberButtonPressed(Integer.parseInt(label));
            }
        });
    }
}
