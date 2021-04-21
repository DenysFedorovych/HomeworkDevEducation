package com.github.converter.swing.buttonaction;

import com.github.converter.swing.JPanelApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionLength implements ActionListener {
    JPanelApp jpa;

    public ButtonActionLength(JPanelApp jpa) {
        this.jpa = jpa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = jpa.current_l2.getText();
        if(jpa.f1.getText()!=null) {
            double num = Double.parseDouble(jpa.f1.getText());
            Double result = 0.0;
            switch (str) {
                case "km": {
                    result = num/1000;
                }
                break;
                case "mile": {
                    result = num/1609.34;
                }
                break;
                case "nautical mile": {
                    result = num/1852;
                }
                break;
                case "cable": {
                    result = num/185.32;
                }
                break;
                case "league": {
                    result = num/5556;
                }
                break;
                case "foot": {
                    result = num/0.3048;
                }
                break;
                case "yard": {
                    result = num/0.9144;
                }
                break;
            }
            String res = result.toString();
            if(res.length()>5) res = res.substring(0,5);
            jpa.f2.setText(res);
            jpa.f1.setText(null);
        }
    }
}
