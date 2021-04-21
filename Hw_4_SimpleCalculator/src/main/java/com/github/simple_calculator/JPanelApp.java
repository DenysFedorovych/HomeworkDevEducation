package com.github.simple_calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JPanelApp extends JPanel
{


    public JPanelApp()
    {

            setBackground(new Color(221,226,206));
            setLayout(null);
            TextField txt1 = new TField(95, 30, 300, 50);
            TextField txt2 = new TField(95, 105, 300, 50);
            TextField txt3 = new TField(95, 180, 300, 50);
            TextField txt4 = new TField(95, 340, 300, 50);

            TLabel l1 = new TLabel("Число 1",5,30,80,50);
            TLabel l2 = new TLabel("Число 2",5,105,80,50);
            TLabel l3 = new TLabel("Операция",5,180,80,50);
            TLabel l4 = new TLabel("Результат",5,340,80,50);

            ImageIcon image = new ImageIcon("/Users/denisfedorovich/IdeaProjects/home-works-dev-education/Hw_4_SimpleCalculator/src/com/github/pictures/copy.png");
            JButton b0 = new JButton(image);
            b0.setBounds(40, 255, 357, 75);

            add(txt1);
            add(l1);
            add(txt2);
            add(l2);
            add(txt3);
            add(l3);
            add(b0);
            add(txt4);
            add(l4);

            ActionListener AL = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s1 = txt1.getText();
                    String s2 = txt2.getText();
                    String s3 = txt3.getText();
                    if(!s1.isBlank()&&!s2.isBlank()&&Calculate.validateOperation(s3)){
                        Double res = Calculate.calculate(s1,s2,s3);
                        txt4.setText(res.toString());
                    }
                    else{
                        txt4.setText("");
                    }
                }
            };

            b0.addActionListener(AL);
    }
}