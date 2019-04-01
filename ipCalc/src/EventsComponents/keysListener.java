/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventsComponents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import utils.components;

/**
 *
 * @author developercrack
 */
public class keysListener implements KeyListener {

    private final components c;
    private final int des;

    public keysListener(components c, int des) {
        this.c = c;
        this.des = des;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!(Character.isDigit(e.getKeyChar()))) {
            e.consume();
        } else {
            if (des == 0 && (c.txtIP1.getText().length() > 2)) {
                e.consume();
            }
            if (des == 1 && (c.txtIP2.getText().length() > 2)) {
                e.consume();
            }
            if (des == 2 && (c.txtIP3.getText().length() > 2)) {
                e.consume();
            }
            if (des == 3 && (c.txtIP4.getText().length() > 2)) {
                e.consume();
            }
            if(des ==4 &&(c.txtBits.getText().length()>1)){
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
