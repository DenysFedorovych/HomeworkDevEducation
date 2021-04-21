package com.github.converter.swing.buttonaction;

import com.github.converter.swing.JPanelApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionTemperature implements ActionListener {
    JPanelApp jpa;

    public ButtonActionTemperature(JPanelApp jpa) {
        this.jpa = jpa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = jpa.current_l2.getText();
        switch(str){
            case "K" :{

            }
            break;
            case "F" :{

            }
            break;
            case "Re" :{

            }
            break;
            case "Ro" :{

            }
            break;
            case "Ra" :{

            }
            break;
            case "N" :{

            }
            break;
            case "D" :{

            }
        }
    }
}
