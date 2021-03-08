package com.github.simple_paint.swing.structures;

import com.github.simple_paint.swing.dialogs.LoadDialog;
import com.github.simple_paint.swing.dialogs.SaveDialog;
import com.github.simple_paint.swing.utils.FileAnalyzer;
import com.github.simple_paint.swing.utils.FileCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConfigPanel extends JPanel {
    public ConfigPanel(GraphicPanel graphicPanel) {
        setBounds(600, 0, 200, 600);
        setBackground(new Color(114, 68, 78));
        setLayout(null);

        JButton colorButton = new JButton("Color");
        colorButton.setBounds(20, 50, 160, 50);

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.setColor(JColorChooser.showDialog(new JFrame(), "Select a color", Color.RED));
            }
        });

        JButton thicknessButton = new JButton("Thickness");
        thicknessButton.setBounds(20, 150, 160, 50);

        thicknessButton.addActionListener(new ActionListener() {
            Integer[] variants = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            @Override
            public void actionPerformed(ActionEvent e) {
                int k = (int) JOptionPane.showInputDialog(new JFrame(), "Thickness : ", "Thickness", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), variants, 1);
                graphicPanel.setThickness(k);
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(20, 250, 160, 50);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.clear();
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(20, 350, 160, 50);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SaveDialog sd = new SaveDialog();
                    if (sd.isNormalEnded()) {
                        FileCreator fileCreator = new FileCreator(sd.getFileExtension(), sd.getFileName(), graphicPanel.getLines());
                    }
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(new JFrame(), "Try again", "Something is wrong", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setBounds(20, 450, 160, 50);

        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoadDialog loadDialog = new LoadDialog();
                    FileAnalyzer fileAnalyzer = new FileAnalyzer(loadDialog.getFile());
                    graphicPanel.repaintLines(fileAnalyzer.getLines());
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(new JFrame(), "Something wrong with file", "Something is wrong", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        add(colorButton);
        add(thicknessButton);
        add(clearButton);
        add(saveButton);
        add(loadButton);

        setVisible(true);
    }
}
