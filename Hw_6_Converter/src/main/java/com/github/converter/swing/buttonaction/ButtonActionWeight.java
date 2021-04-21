package com.github.converter.swing.buttonaction;

import com.github.converter.swing.JPanelApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionWeight implements ActionListener {
    JPanelApp jpa;

    public ButtonActionWeight(JPanelApp jpa) {
        this.jpa = jpa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = jpa.current_l2.getText();
        switch(str){
            case "g" :{

            }
            break;
            case "carat" :{

            }
            break;
            case "eng pound" :{

            }
            break;
            case "pound" :{

            }
            break;
            case "stone" :{

            }
            break;
            case "rus pound" :{

            }
            break;
        }
    }
}
