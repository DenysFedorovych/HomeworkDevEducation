package com.github.converter.swing.buttonaction;

import com.github.converter.swing.JPanelApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionVolume implements ActionListener {
    JPanelApp jpa;

    public ButtonActionVolume(JPanelApp jpa) {
        this.jpa = jpa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = jpa.current_l2.getText();
        switch(str){
            case "m^3" :{

            }
            break;
            case "gallon" :{

            }
            break;
            case "pint" :{

            }
            break;
            case "quart" :{

            }
            break;
            case "barrel" :{

            }
            break;
            case "cubic foot" :{

            }
            break;
            case "cubic inch" :{

            }
            break;
        }
    }
}
