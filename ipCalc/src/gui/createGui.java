/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import EventsComponents.clickListenerEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.Areas;
import utils.components;
import EventsComponents.keysListener;
import EventsComponents.listenerGralClick;
import utils.setImages;

/**
 *
 * @author developercrack
 */
public class createGui {

    private final components c;
    private final setImages sI;

    public createGui() {
        sI = new setImages();
        c = new components();
        initComponents("Calculadora de IP", 600, -200);

    }

    private void initComponents(String name, int x, int y) {
        c.jf = new JFrame(name);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        c.jf.setBounds(0, 0, (d.width - x) / 2, (d.height - y) / 2);
        c.jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        c.jf.setResizable(false);
        c.jf.setLocationRelativeTo(null);
        c.img = new ImageIcon(this.getClass().getResource("/images/ipImage.png"));
        c.jf.setIconImage(c.img.getImage());
        c.jf.setLayout(null);
        declareComponents();
        c.jf.setVisible(true);
    }

    private void declareComponents() {
        c.lbl = new JLabel[19];
        c.btn = new JLabel[3];
        for (int i = 0; i != 19; i++) {
            if ((i >= 1 && i <= 3) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) {
                c.lbl[i] = new JLabel(c.str[1]);
            } else if (i == 0) {
                c.lbl[i] = new JLabel(c.str[0]);
            } else if (i == 4) {
                c.lbl[i] = new JLabel(c.str[2]);
            } else if (i == 5) {
                c.lbl[i] = new JLabel(c.str[3]);
            } else if (i == 6) {
                c.lbl[i] = new JLabel(c.str[4]);
            } else if (i == 7) {
                c.lbl[i] = new JLabel(c.str[5]);
            } else if (i == 11) {
                c.lbl[i] = new JLabel(c.str[6]);
            } else if (i == 15) {
                c.lbl[i] = new JLabel(c.str[7]);
            } else if (i == 16) {
                c.lbl[i] = new JLabel(c.str[8]);
            } else if (i == 17) {
                c.lbl[i] = new JLabel(c.str[9]);
            } else {
                c.lbl[i] = new JLabel(c.str[10]);
            }
        }

        for (int i = 0; i < 3; i++) {
            c.btn[i] = new JLabel();
        }
        c.txtBits = new JTextField();
        c.txtClass = new JLabel();
        c.txtHost = new JTextField();
        c.txtIP1 = new JTextField();
        c.txtIP2 = new JTextField();
        c.txtIP3 = new JTextField();
        c.txtIP4 = new JTextField();
        c.txtMA1 = new JLabel();
        c.txtMA2 = new JLabel();
        c.txtMA3 = new JLabel();
        c.txtMA4 = new JLabel();
        c.txtSu1 = new JLabel();
        c.txtSu2 = new JLabel();
        c.txtSu3 = new JLabel();
        c.txtSu4 = new JLabel();
        c.txtSub = new JLabel();
        c.txtType = new JLabel();
        c.cbxEnableBits = new JCheckBox();
        c.subredes = new Areas("Subredes", 0, 20, 270);
        c.rangos = new Areas("Rangos", 1, 190, 270);
        locateComponents();
    }

    private void locateComponents() {
        c.lbl[0].setBounds(20, 30, 90, 30);
        c.txtIP1.setBounds(110, 30, 40, 30);
        c.lbl[1].setBounds(150, 30, 30, 30);
        c.txtIP2.setBounds(155, 30, 40, 30);
        c.lbl[2].setBounds(195, 30, 30, 30);
        c.txtIP3.setBounds(200, 30, 40, 30);
        c.lbl[3].setBounds(240, 30, 30, 30);
        c.txtIP4.setBounds(245, 30, 40, 30);
        c.lbl[4].setBounds(285, 30, 30, 30);
        c.txtBits.setBounds(290, 30, 40, 30);
        c.cbxEnableBits.setBounds(330, 30, 30, 30);
        c.lbl[5].setBounds(20, 70, 60, 30);
        c.txtHost.setBounds(90, 70, 80, 30);
        c.lbl[6].setBounds(180, 70, 80, 30);
        c.txtSub.setBounds(260, 70, 100, 30);
        c.lbl[7].setBounds(20, 110, 130, 30);
        c.txtMA1.setBounds(160, 110, 40, 30);
        c.lbl[8].setBounds(185, 110, 30, 30);
        c.txtMA2.setBounds(190, 110, 40, 30);
        c.lbl[9].setBounds(215, 110, 30, 30);
        c.txtMA3.setBounds(220, 110, 40, 30);
        c.lbl[10].setBounds(245, 110, 30, 30);
        c.txtMA4.setBounds(250, 110, 40, 30);
        c.lbl[11].setBounds(20, 150, 150, 30);
        c.txtSu1.setBounds(170, 150, 40, 30);
        c.lbl[12].setBounds(195, 150, 150, 30);
        c.txtSu2.setBounds(200, 150, 40, 30);
        c.lbl[13].setBounds(225, 150, 150, 30);
        c.txtSu3.setBounds(230, 150, 40, 30);
        c.lbl[14].setBounds(255, 150, 150, 30);
        c.txtSu4.setBounds(260, 150, 40, 30);
        c.lbl[15].setBounds(20, 190, 100, 30);
        c.txtClass.setBounds(70, 190, 100, 30);
        c.lbl[16].setBounds(200, 190, 100, 30);
        c.txtType.setBounds(240, 190, 100, 30);
        c.lbl[17].setBounds(50, 230, 100, 30);
        c.lbl[18].setBounds(200, 230, 100, 30);
        c.btn[0].setBounds(40, 385, 70, 70);
        c.btn[1].setBounds(140, 385, 70, 70);
        c.btn[2].setBounds(240, 385, 70, 70);
        addComponents();
    }

    private void addComponents() {
        for (int i = 0; i < 19; i++) {
            c.jf.add(c.lbl[i]);
        }
        for (int i = 0; i < 3; i++) {
            c.jf.add(c.btn[i]);
        }
        c.jf.add(c.subredes.getSp());
        c.jf.add(c.rangos.getSp());
        c.jf.add(c.txtIP1);
        c.jf.add(c.txtIP2);
        c.jf.add(c.txtIP3);
        c.jf.add(c.txtIP4);
        c.jf.add(c.txtBits);
        c.jf.add(c.cbxEnableBits);
        c.jf.add(c.txtSub);
        c.jf.add(c.txtMA1);
        c.jf.add(c.txtMA2);
        c.jf.add(c.txtMA3);
        c.jf.add(c.txtMA4);
        c.jf.add(c.txtSu1);
        c.jf.add(c.txtSu2);
        c.jf.add(c.txtSu3);
        c.jf.add(c.txtSu4);
        c.jf.add(c.txtType);
        c.jf.add(c.txtClass);
        c.jf.add(c.txtHost);
        setSettings();
    }

    private void setSettings() {
        c.txtBits.setEnabled(false);
        c.cbxEnableBits.addActionListener(new clickListenerEvent(c, 0));
        sI.setLabel(c.btn[0], "/images/clear.png");
        sI.setLabel(c.btn[1], "/images/ipIcon.png");
        sI.setLabel(c.btn[2], "/images/showMore.png");
        for (int i = 0; i < 3; i++) {
            c.btn[i].addMouseListener(new listenerGralClick(c, 1 + i));
        }
        c.txtIP1.addKeyListener(new keysListener(c, 0));
        c.txtIP2.addKeyListener(new keysListener(c, 1));
        c.txtIP3.addKeyListener(new keysListener(c, 2));
        c.txtIP4.addKeyListener(new keysListener(c, 3));
        c.txtBits.addKeyListener(new keysListener(c, 4));
        c.txtHost.addKeyListener(new keysListener(c, 5));
        c.txtSub.addKeyListener(new keysListener(c, 6));
    }
}
