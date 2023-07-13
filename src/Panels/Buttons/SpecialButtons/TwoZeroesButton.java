package Panels.Buttons.SpecialButtons;

import Panels.Buttons.OrdinaryButton;

import java.awt.event.ActionListener;

public class TwoZeroesButton  extends OrdinaryButton {

    public TwoZeroesButton(String label, ActionListener actionListener){
        super(label);
        addActionListener(actionListener);
    }
}
