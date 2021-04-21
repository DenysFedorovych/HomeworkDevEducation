package com.github.converter.swing;

import javax.swing.*;
import java.awt.*;

public class TLabel extends JLabel {
    public TLabel(String str, int x, int y, int width, int height){
        setBounds(x,y,width,height);
        setText(str);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setFont(new Font("Default",0,11));
    }
}
