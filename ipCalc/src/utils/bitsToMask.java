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
public class bitsToMask {

    public static byte getValue(int value) {
        switch (value) {
            case 0:
                return (byte) 0;
            case 1:
                return (byte) 128;
            case 2:
                return (byte) 192;
            case 3:
                return (byte) 224;
            case 4:
                return (byte) 240;
            case 5:
                return (byte) 248;
            case 6:
                return (byte) 252;
            case 7:
                return (byte) 254;
            default:
                return (byte) 255;
        }
    }

    private static int getInt(byte a) {
        switch (a) {
            case (byte) 255:
                return 255;
            case (byte) 254:
                return 254;
            case (byte) 252:
                return 252;
            case (byte) 248:
                return 248;
            case (byte) 240:
                return 240;
            case (byte) 224:
                return 224;
            case (byte) 192:
                return 192;
            case (byte) 128:
                return 128;
            default:
                return 0;
        }
    }

    public static void setSubMask(byte arr[], components c) {
        int i, arrB[];
        arrB = new int[4];
        for (i = 0; i != 4; i++) {
            arrB[i] = getInt(arr[i]);
        }
        c.txtSu1.setText(arrB[0] + "");
        c.txtSu2.setText(arrB[1] + "");
        c.txtSu3.setText(arrB[2] + "");
        c.txtSu4.setText(arrB[3] + "");
    }

    public static void setSub(components c, byte macS[], byte macR[]) {
        boolean ban;
        int biGral = 0, bitsSub = 0;
        switch (c.txtClass.getText()) {
            case "A":
            case "B":
            case "C":
                ban = false;
                break;
            default:
                ban = true;
        }
        if (!ban) {
            int i = Integer.parseInt(c.txtHost.getText())+1, bits = 0, j;
            while (i != 0) {
                bits++;
                i /= 2;
            }
            i = 1;
            switch (c.txtClass.getText()) {
                case "A":
                    biGral = 8;
                    break;
                case "B":
                    biGral = 16;
                    break;
                case "C":
                    biGral = 24;
                    break;
                default:
                    biGral = 33;
            }
            for (j = 0; j != bits; j++) {
                i *= 2;
            }
            c.txtHost.setText(i - 2 + "");
            System.out.println("bits= " + bits + " hosts= " + (i - 2));
            if ((biGral + bits) > 32) {
                JOptionPane.showConfirmDialog(null, "No se puede realizar "
                        + "la opercaión", "Error", JOptionPane.ERROR_MESSAGE);
                c.txtHost.setText("-1");
                c.txtSub.setText("-1");
            } else {
                bitsSub = 32 - (biGral + bits);
                c.txtBits.setText(biGral + bits + "");
                c.txtSub.setText(((int) Math.pow(2, bitsSub)) - 2 + "");
                if (c.txtType.getText().compareTo("Loopback") == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede realizar "
                            + "subneteo a loopback", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
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
                                default: {
                                    int top = 0;
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
                                    }
                                    i = Integer.parseInt(c.txtBits.getText());
                                    System.out.println(i + "");
                                    macS[0] = macR[0] = (byte) Integer.parseInt(c.txtMA1.getText());
                                    macS[1] = macR[1] = (byte) Integer.parseInt(c.txtMA2.getText());
                                    macS[2] = macR[2] = (byte) Integer.parseInt(c.txtMA3.getText());
                                    macS[3] = macR[3] = (byte) Integer.parseInt(c.txtMA4.getText());
                                    for (j = 0; j != 4; j++) {
                                        macS[j] = bitsToMask.getValue(i);
                                        i -= 8;
                                        if (i < 0) {
                                            i = 0;
                                        }
                                    }
                                    bitsToMask.setSubMask(macS, c);
                                    macSub ms = new macSub(macR, macS, c);
                                    ms.createSame();

                                }
                            }
                    }
                }
            }
        } else {
            c.txtHost.setText("-1");
            c.txtSub.setText("-1");
        }
    }
}
