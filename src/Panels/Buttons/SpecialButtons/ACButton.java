package Panels.Buttons.SpecialButtons;


import Panels.Buttons.OrdinaryButton;

import java.awt.event.ActionListener;

public class ACButton extends OrdinaryButton {
    public ACButton(ActionListener actionListener){
        super("AC");
        addActionListener(actionListener);
    }
}