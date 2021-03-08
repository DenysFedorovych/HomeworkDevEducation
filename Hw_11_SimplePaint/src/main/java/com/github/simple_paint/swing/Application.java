package com.github.simple_paint.swing;

import com.github.simple_paint.swing.structures.ConfigPanel;
import com.github.simple_paint.swing.structures.FramePaint;
import com.github.simple_paint.swing.structures.GraphicPanel;

public class Application {
    public static void main(String[] args) {
        GraphicPanel panel = new GraphicPanel();
        ConfigPanel configPanel = new ConfigPanel(panel);
        FramePaint frame = new FramePaint(panel, configPanel);
    }
}