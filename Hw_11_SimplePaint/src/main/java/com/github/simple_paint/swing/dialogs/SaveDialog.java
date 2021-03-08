package com.github.simple_paint.swing.dialogs;

import com.github.simple_paint.swing.utils.Extension;

import javax.swing.*;

public class SaveDialog extends JDialog {

    private Extension fileExtension;
    private String fileName;
    private int result = -1;

    public SaveDialog() {

        JComboBox<Extension> extensions = new JComboBox<>(Extension.values());
        JTextField fileName = new JTextField();
        final JComponent[] inputs = new JComponent[]{
                new JLabel("File type : "),
                extensions,
                new JLabel("File name : "),
                fileName
        };
        result = JOptionPane.showConfirmDialog(null, inputs, "Create file", JOptionPane.PLAIN_MESSAGE);
        if (isNormalEnded()) {
            this.fileExtension = (Extension) extensions.getSelectedItem();
            this.fileName = fileName.getText();
        }

    }

    public boolean isNormalEnded(){
        return result == JOptionPane.OK_OPTION;
    }

    public Extension getFileExtension() {
        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

}
