package com.github.simple_calculator;

import javax.swing.JFrame;
import java.awt.Color;

public class SimpleCalculator extends JFrame
{
    public SimpleCalculator()
    {
        setBounds(100, 100, 430, 440);
        setBackground(new Color(221,226,206));
        setTitle("Калькулятор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add( new JPanelApp());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new SimpleCalculator();
    }
}