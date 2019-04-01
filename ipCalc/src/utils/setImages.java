/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author developercrack
 */
public class setImages {

    public setImages() {
    }

    public void setLabel(JLabel lbl, String url) {
        try {
            ImageIcon i;
            i = new ImageIcon(this.getClass().getResource(url));
            i = new ImageIcon(i.getImage().getScaledInstance(lbl.getWidth(),
                    lbl.getHeight(), Image.SCALE_SMOOTH));
            lbl.setIcon(i);
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }
}
