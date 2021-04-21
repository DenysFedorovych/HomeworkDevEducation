package com.github.converter.swing;

import com.github.converter.swing.buttonaction.ButtonActionLength;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemChoose implements ActionListener {
    private JPanelApp jpa;
    
    public ItemChoose(JPanelApp jpa) {
        this.jpa = jpa;
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox box = (JComboBox) e.getSource();
        String item = (String) box.getSelectedItem();
        String label = null;
        jpa.remove(jpa.current);
        jpa.remove(jpa.current_l1);
        ActionListener al = null;
        String[] suit = null;
        switch (item){
            case "Length" : {
                suit = StringLists.items_length;
                label = "Metres ";
                al = new ButtonActionLength(jpa);
            }
            break;
            case "Temperature" : {
                suit = StringLists.items_temp;
                label = "Celsius ";
            }
            break;
            case "Weight" : {
                suit = StringLists.items_weight;
                label = "Kilograms ";
            }
            break;
            case "Time" : {
                suit = StringLists.items_time;
                label = "Seconds ";
            }
            break;
            case "Volume" : {
                suit = StringLists.items_volume;
                label = "Litres ";
            }
            break;
        }
        jpa.button.addActionListener(al);
        jpa.current_l1.setText(label);
        jpa.current = new JComboBox<>(suit);
        jpa.current.addActionListener(jpa.AL1);
        jpa.current.setBounds(220,10,100,50);
        jpa.add(jpa.current);
        jpa.add(jpa.current_l1);
        SwingUtilities.updateComponentTreeUI(jpa.converter);
    }
}
