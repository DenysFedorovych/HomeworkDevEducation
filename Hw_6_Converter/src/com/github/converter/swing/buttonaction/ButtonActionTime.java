package com.github.converter.swing.buttonaction;

import com.github.converter.swing.JPanelApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionTime implements ActionListener {
    JPanelApp jpa;

    public ButtonActionTime(JPanelApp jpa) {
        this.jpa = jpa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = jpa.current_l2.getText();
        switch(str){
            case "min" :{

            }
            break;
            case "hour" :{

            }
            break;
            case "day" :{

            }
            break;
            case "week" :{

            }
            break;
            case "month" :{

            }
            break;
            case "astronomical years" :{

            }
            break;
        }
    }
}
