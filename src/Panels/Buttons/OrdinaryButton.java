package Panels.Buttons;

import java.awt.*;

public class OrdinaryButton extends Button {
    protected OrdinaryButton(String label){
        super(label);
        setFont(new Font("TimesRoman",Font.BOLD,30));
    }
}
