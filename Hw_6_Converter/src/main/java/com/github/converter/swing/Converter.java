package com.github.converter.swing;

import javax.swing.*;
import java.awt.*;

public class Converter extends JFrame
{
    public Converter()
    {
        setBounds(200, 200, 400, 200);
        setTitle("Конвертер");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add( new JPanelApp(this));
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Converter();
    }
}