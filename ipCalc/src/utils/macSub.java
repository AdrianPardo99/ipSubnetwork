/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author developercrack
 */
public class macSub {

    private final byte[] macR, macS;
    private final components c;

    public macSub(byte[] macR, byte[] macS, components c) {
        this.macR = macR;
        this.macS = macS;
        this.c = c;
    }

    public void createMS() {
        int i, top;
        boolean ban;
        ban = c.txtBits.getText().isEmpty();
        if (ban) {
            JOptionPane.showMessageDialog(null, "No dejar vacio el "
                    + "campo de bits para el subneteo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            i = Integer.parseInt(c.txtBits.getText());
            if (i > 32) {
                JOptionPane.showMessageDialog(null, "No se puede trabajar "
                        + "con bits mayor a 32", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (c.txtType.getText().compareTo("Loopback") == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede realizar "
                            + "subneteo a loopback", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    switch (c.txtClass.getText()) {
                        case "A":
                            top = 8;
                            break;
                        case "B":
                            top = 16;
                            break;
                        case "C":
                            top = 24;
                            break;
                        default:
                            top = 33;
                            break;
                    }
                    if (i < top) {
                        JOptionPane.showMessageDialog(null, "Por favor usa "
                                + "más bits", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        macS[0] = macR[0] = (byte) Integer.parseInt(c.txtMA1.getText());
                        macS[1] = macR[1] = (byte) Integer.parseInt(c.txtMA2.getText());
                        macS[2] = macR[2] = (byte) Integer.parseInt(c.txtMA3.getText());
                        macS[3] = macR[3] = (byte) Integer.parseInt(c.txtMA4.getText());
                        int j;
                        for (j = 0; j != 4; j++) {
                            macS[j] = bitsToMask.getValue(i);
                            i -= 8;
                            if (i < 0) {
                                i = 0;
                            }
                        }
                        bitsToMask.setSubMask(macS, c);
                        i = Integer.parseInt(c.txtBits.getText());
                        c.txtSub.setText((((int) Math.pow(2, (i - top))) - 2) + "");
                        c.txtHost.setText((((int) Math.pow(2, (32 - i))) - 2) + "");
                        switch (c.txtSub.getText()) {
                            case "-1":
                            case "0":
                                JOptionPane.showMessageDialog(null,
                                        "Imposible realizar operaciones",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                                break;
                            default:
                                switch (c.txtHost.getText()) {
                                    case "-1":
                                    case "0":
                                        JOptionPane.showMessageDialog(null,
                                                "Imposible realizar operaciones",
                                                "Warning", JOptionPane.WARNING_MESSAGE);
                                        break;
                                    default:
                                        createSame();
                                }
                        }
                    }
                }
            }
        }
    }

    public void createSame() {
        int mask[], ip[], idIP[], maskS[], ipTop[], j;
        mask = new int[4];
        ip = new int[4];
        idIP = new int[4];
        maskS = new int[4];
        ipTop = new int[4];
        ip[0] = Integer.parseInt(c.txtIP1.getText());
        ip[1] = Integer.parseInt(c.txtIP2.getText());
        ip[2] = Integer.parseInt(c.txtIP3.getText());
        ip[3] = Integer.parseInt(c.txtIP4.getText());
        mask[0] = Integer.parseInt(c.txtMA1.getText());
        mask[1] = Integer.parseInt(c.txtMA2.getText());
        mask[2] = Integer.parseInt(c.txtMA3.getText());
        mask[3] = Integer.parseInt(c.txtMA4.getText());
        maskS[0] = Integer.parseInt(c.txtSu1.getText());
        maskS[1] = Integer.parseInt(c.txtSu2.getText());
        maskS[2] = Integer.parseInt(c.txtSu3.getText());
        maskS[3] = Integer.parseInt(c.txtSu4.getText());
        byte som, som2;
        for (j = 0; j != 4; j++) {
            idIP[j] = (ip[j] & mask[j]);
            if (maskS[j] == 0x00) {
                ipTop[j] = (idIP[j] | 0x000000ff);
            } else {
                som = (byte) idIP[j];
                som2 = (byte) ~macS[j];
                ipTop[j] = (byte) (som | (som2)) & 0xff;
            }
        }
        int i = Integer.parseInt(c.txtBits.getText()), veces = 0, k;
        for (k = 0; k != 4; k++) {
            if (i > 8) {
                i -= 8;
                veces++;
            } else {
                break;
            }
        }
        ipTop[veces] = (ipTop[veces] ^ 0xff);
        int numHost = Integer.parseInt(c.txtHost.getText());
        logicSumIP lsi = new logicSumIP(idIP, ipTop, c, numHost);
        lsi.initArray();
        c.arrSN = lsi.getArrSN();
    }
}
