/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author developercrack
 */
public class Areas {

    private JScrollPane sp;
    private JTextArea txt;
    private String name;
    private final int x, y;
    private int des;

    public Areas(String name, int des, int x, int y) {
        this.name = name;
        this.des = des;
        this.x = x;
        this.y = y;
        initArea();
    }

    private void initArea() {
        sp = new JScrollPane();
        txt = new JTextArea();
        initLocate();
    }

    private void initLocate() {
        sp.setBounds(x, y, 150, 110);
        txt.setBounds(x, y, 150, 110);
        add();
    }

    private void add() {
        sp.add(txt);
        txt.setLineWrap(true);
        sp.setViewportView(txt);
        txt.setEditable(false);
    }

    public JScrollPane getSp() {
        return sp;
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }

    public JTextArea getTxt() {
        return txt;
    }

    public void setTxt(JTextArea txt) {
        this.txt = txt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

}
