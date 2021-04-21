package com.github.converter.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JPanelApp extends JPanel
{
    public Converter converter;
    public JComboBox current;
    public JLabel current_l1;
    public JLabel current_l2;
    public ActionListener AL1;
    public TField f1;
    public TField f2;
    public JButton button;

    public JPanelApp(Converter converter)
    {
        this.converter = converter;
        setBackground(new Color(150,200,200));
        setLayout(null);
        current_l1 = new JLabel("Data");
        current_l1.setBounds(10,60,80,50);
        current_l2 = new JLabel("Data");
        current_l2.setBounds(310,60,80,50);
        current_l2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(current_l1);
        add(current_l2);
        current = new JComboBox();
        button = new JButton("Convert");
        button.setBounds(100,130,200,40);
        add(button);

        JComboBox<String> item = new JComboBox<>(StringLists.items);
        item.setBounds(90,10,100,50);
        item.addActionListener(new ItemChoose(this));
        add(item);

        AL1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox) e.getSource();
                String item = (String) box.getSelectedItem();
                remove(current_l2);
                current_l2.setText(item);
                add(current_l2);
                SwingUtilities.updateComponentTreeUI(converter);
            }
        };

        current.addActionListener(AL1);
        add(new TLabel("Choose data : ",10,10,80,50));

        f1 = new TField(95,60,80,50);
        add(f1);

        f2 = new TField(225,60,80,50);
        add(f2);


    }
}