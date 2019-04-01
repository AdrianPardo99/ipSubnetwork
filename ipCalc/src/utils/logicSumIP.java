/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import entities.subnetwork;

/**
 *
 * @author developercrack
 */
public class logicSumIP {

    private final int ipInit[], ipTop[], numHost;
    private final components c;
    private ArrayList<subnetwork> arrSN;

    public logicSumIP(int[] ipInit, int[] ipTop, components c, int numHost) {
        this.ipInit = ipInit;
        this.ipTop = ipTop;
        this.c = c;
        this.numHost = numHost;
        arrSN = new ArrayList<>();
    }

    private boolean isSame(int arr[], int arr2[]) {
        return ((arr[0] == arr2[0]) && (arr[1] == arr2[1])
                && (arr[2] == arr2[2]) && (arr[3] == arr2[3]));
    }

    public void initArray() {
        int bits = Integer.parseInt(c.txtBits.getText()),
                numSub = Integer.parseInt(c.txtSub.getText()), macs[],
                ipCen[];
        macs = new int[4];
        c.subredes.getTxt().setText("");
        macs[0] = Integer.parseInt(c.txtSu1.getText());
        macs[1] = Integer.parseInt(c.txtSu2.getText());
        macs[2] = Integer.parseInt(c.txtSu3.getText());
        macs[3] = Integer.parseInt(c.txtSu4.getText());
        int cen = numHost+2;
        System.out.println("IS SAME " + isSame(ipInit, ipTop));
        while (numSub != 0) {
            ipCen = new int[4];
            while (cen != 0) {
                if (ipInit[3] == 0xff) {
                    ipInit[3] = 0x01;
                    if (ipInit[2] == 0xff) {
                        ipInit[2] = 0x01;
                        if (ipInit[1] == 0xff) {
                            ipInit[1] = 0x01;
                            ipInit[0] += 1;
                        } else {
                            ipInit[1] += 1;
                        }
                    } else {
                        ipInit[2] += 1;
                    }
                } else {
                    ipInit[3] += 1;
                }
                cen--;
            }
            cen = numHost+2;
            numSub--;
            for (int k = 0; k != 4; k++) {
                ipCen[k] = ipInit[k];
            }
            arrSN.add(new subnetwork(ipCen, bits, macs));
            arrSN.get(arrSN.size() - 1).generateArr(numHost);
        }
        arrSN.forEach((sn) -> {
            c.subredes.getTxt().setText(c.subredes.getTxt().getText()
                    + sn.toString() + "\n");
        });
    }

    public ArrayList<subnetwork> getArrSN() {
        return arrSN;
    }

    public void setArrSN(ArrayList<subnetwork> arrSN) {
        this.arrSN = arrSN;
    }

}
