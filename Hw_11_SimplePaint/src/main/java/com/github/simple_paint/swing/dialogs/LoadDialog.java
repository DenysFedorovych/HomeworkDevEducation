package com.github.simple_paint.swing.dialogs;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class LoadDialog {

    private final String[] extensions = {"json","csv","yml","xml","bin"};

    private FileNameExtensionFilter filter = new FileNameExtensionFilter("",extensions);

    private File file;

    public LoadDialog(){

            JFileChooser jFileChooser = new JFileChooser("/Users/denisfedorovich/IdeaProjects/home-works-dev-education/Hw_11_SimplePaint/src/main/java/com/github/simple_paint/swing/storage/");
            jFileChooser.setFileFilter(filter);
            jFileChooser.showOpenDialog(new JFrame());
            file = jFileChooser.getSelectedFile();

    }

    public File getFile(){
        return this.file;
    }
}
