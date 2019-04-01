/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import entities.subnetwork;

/**
 *
 * @author developercrack
 */
public class components {

    public JFrame jf;
    public JCheckBox cbxEnableBits;
    public JTextField txtIP1, txtIP2, txtIP3, txtIP4, txtHost, txtBits;
    public JLabel lbl[], txtSub, txtMA1, txtMA2, txtMA3, txtMA4, txtSu1,
            txtSu2, txtSu3, txtSu4, txtClass, txtType;
    public String str[] = {"IP:", ".", "/", "Host's:", "Subredes:",
        "Mascara de red:", "Mascara de subred:", "Clase:", "Tipo:",
        "Subredes:", "Rango IP:"},
            strClass[] = {"A", "B", "C", "D", "E", "Broadcast"},
            strType[] = {"Publica", "Privada", "Loopback", "Broadcast"};
    public ImageIcon img;
    public JLabel btn[];
    public Areas subredes, rangos;
    public ArrayList<subnetwork> arrSN;
}
