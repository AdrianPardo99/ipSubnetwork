/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventsComponents;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import entities.ipAddr;
import entities.subnetwork;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import utils.bitsToMask;
import utils.components;
import utils.macSub;
import utils.whatClass;

/**
 *
 * @author developercrack
 */
public class listenerGralClick implements MouseListener {

    private final components c;
    private final int des;

    public listenerGralClick(components c, int des) {
        this.c = c;
        this.des = des;
    }

    private void initClear() {
        System.out.println("Init clear");
        c.txtBits.setText("");
        c.txtClass.setText("");
        c.txtHost.setText("");
        c.txtIP1.setText("");
        c.txtIP2.setText("");
        c.txtIP3.setText("");
        c.txtIP4.setText("");
        c.txtMA1.setText("");
        c.txtMA2.setText("");
        c.txtMA3.setText("");
        c.txtMA4.setText("");
        c.txtSu1.setText("");
        c.txtSu2.setText("");
        c.txtSu3.setText("");
        c.txtSu4.setText("");
        c.txtSub.setText("");
        c.txtType.setText("");
        c.rangos.getTxt().setText("");
        c.subredes.getTxt().setText("");
        c.cbxEnableBits.setSelected(false);
        c.txtBits.setEnabled(false);
    }

    private void initCalculate() {
        System.out.println("Init calculate");
        int i[];
        boolean ban = false, x[];
        i = new int[4];
        x = new boolean[4];
        x[0] = c.txtIP1.getText().isEmpty();
        x[1] = c.txtIP2.getText().isEmpty();
        x[2] = c.txtIP3.getText().isEmpty();
        x[3] = c.txtIP4.getText().isEmpty();
        if (x[0] || x[1] || x[2] || x[3]) {
            JOptionPane.showMessageDialog(null, "No dejar vacio alguno de "
                    + "los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            i[0] = Integer.parseInt(c.txtIP1.getText());
            i[1] = Integer.parseInt(c.txtIP2.getText());
            i[2] = Integer.parseInt(c.txtIP3.getText());
            i[3] = Integer.parseInt(c.txtIP4.getText());
            for (int j = 0; j < 4; j++) {
                if (i[j] > 255) {
                    ban = false;
                    break;
                }
                ban = true;
            }
            if (!ban) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa "
                        + "entre el rango 0-255", "Error IP",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                byte ip[], mask[], maskS[];
                ip = new byte[4];
                mask = new byte[4];
                maskS = new byte[4];
                for (int j = 0; j < 4; j++) {
                    ip[j] = (byte) i[j];
                }
                whatClass wc = new whatClass(ip, c);
                macSub ms = new macSub(mask, maskS, c);
                if (c.cbxEnableBits.isSelected()) {
                    ms.createMS();
                } else {
                    boolean ho;
                    ho = c.txtHost.getText().isEmpty();
                    if (ho) {
                        JOptionPane.showMessageDialog(null, "Por favor llena "
                                + "el campo de host", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.out.println("Subredes");
                        bitsToMask.setSub(c, maskS, mask);
                    }
                }
            }
        }
    }

    private void initRange() {
        System.out.println("Init range");
        if (c.subredes.getTxt().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede trabajar con"
                    + " nada", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String arg[];
            arg = new String[c.arrSN.size()];
            for (int i = 0; i != arg.length; i++) {
                arg[i] = c.arrSN.get(i).toString();
            }
            String s = (String) JOptionPane.showInputDialog(null, "Selecciona una subred",
                    "Subrred", JOptionPane.DEFAULT_OPTION, null, arg, arg[0]);
            if (s != null) {
                int index = 0;
                for (int i = 0; i != arg.length; i++) {
                    if (arg[i].compareTo(s) == 0) {
                        index = i;
                        break;
                    }
                }
                subnetwork sub = c.arrSN.get(index);
                sub.generateArr(Integer.parseInt(c.txtHost.getText()));
                ArrayList<ipAddr> arrIP = sub.getArrIP();
                c.rangos.getTxt().setText("");
                for (ipAddr i : arrIP) {
                    c.rangos.getTxt().setText(c.rangos.getTxt().getText()
                            + i.toString() + "\n");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (des) {
            case 0:
                break;
            case 1:
                initClear();
                break;
            case 2:
                initCalculate();
                break;
            case 3:
                initRange();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
