/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventsComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.components;

/**
 *
 * @author developercrack
 */
public class clickListenerEvent implements ActionListener{

    private final components c;
    private final int des;

    public clickListenerEvent(components c, int des) {
        this.c = c;
        this.des = des;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (des) {
            case 0:
                initConfBits();
                break;
        }
    }

    private void initConfBits() {
        if (c.cbxEnableBits.isSelected()) {
            c.txtBits.setEnabled(true);
        } else {
            c.txtBits.setEnabled(false);
        }
    }
    
}
