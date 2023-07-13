package Panels.Buttons.SpecialButtons;

import Panels.Buttons.OrdinaryButton;

import java.awt.event.ActionListener;

public class DotButton extends OrdinaryButton {

    public DotButton(ActionListener actionListener){
        super(".");
        addActionListener(actionListener);
    }
}
