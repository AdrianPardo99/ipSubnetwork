/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author developercrack
 */
public class whatClass {

    private final byte[] ip;
    private final components c;

    public whatClass(byte[] ip, components c) {
        this.ip = ip;
        this.c = c;
        calculaClass();
        setType();
    }

    private void calculaClass() {
        if (ip[0] >= 0 && ip[0] <= 127) {
            c.txtClass.setText(c.strClass[0]);
            c.txtMA1.setText("255");
            c.txtMA2.setText("0");
            c.txtMA3.setText("0");
            c.txtMA4.setText("0");
        } else if (ip[0] >= (byte) 128 && ip[0] <= (byte) 191) {
            c.txtClass.setText(c.strClass[1]);
            c.txtMA1.setText("255");
            c.txtMA2.setText("255");
            c.txtMA3.setText("0");
            c.txtMA4.setText("0");
        } else if (ip[0] >= (byte) 192 && ip[0] <= (byte) 223) {
            c.txtClass.setText(c.strClass[2]);
            c.txtMA1.setText("255");
            c.txtMA2.setText("255");
            c.txtMA3.setText("255");
            c.txtMA4.setText("0");
        } else if (ip[0] >= (byte) 224 && ip[0] <= (byte) 239) {
            c.txtClass.setText(c.strClass[3]);
            c.txtMA1.setText("X");
            c.txtMA2.setText("X");
            c.txtMA3.setText("X");
            c.txtMA4.setText("X");
        } else {
            c.txtClass.setText(c.strClass[4]);
            c.txtMA1.setText("X");
            c.txtMA2.setText("X");
            c.txtMA3.setText("X");
            c.txtMA4.setText("X");
        }
    }

    private void setType() {
        if (ip[0] == 10 || (ip[0] == (byte) 172 && (ip[1] >= 16
                && ip[1] <= 32)) || (ip[0] == (byte) 192
                && ip[1] == (byte) 168)) {
            c.txtType.setText(c.strType[1]);
        } else if (ip[0] == (byte) 127) {
            c.txtType.setText(c.strType[2]);
        } else if (ip[0] == (byte) 255 && ip[1] == (byte) 255 && 
                ip[2] == (byte) 255 && ip[3] == (byte) 255) {
            c.txtType.setText(c.strType[3]);
        }else{
            c.txtType.setText(c.strType[0]);
        }
    }

}
