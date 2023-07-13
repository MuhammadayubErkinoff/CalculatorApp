package Panels.Buttons.SpecialButtons;


import Panels.Buttons.OrdinaryButton;

import java.awt.event.ActionListener;

public class EqualsButton extends OrdinaryButton {

    public EqualsButton( ActionListener actionListener){
        super("=");
        addActionListener(actionListener);
    }
}
