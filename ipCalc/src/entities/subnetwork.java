/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author developercrack
 */
public class subnetwork {

    private int ipID[], bits;
    private final int maskS[];
    private ArrayList<ipAddr> arrIP;

    public subnetwork(int[] ipID, int bits, int[] maskS) {
        this.ipID = ipID;
        this.bits = bits;
        this.maskS = maskS;
    }
    
    public int[] getIpID() {
        return ipID;
    }

    public void setIpID(int[] ipID) {
        this.ipID = ipID;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public ArrayList<ipAddr> getArrIP() {
        return arrIP;
    }

    public void setArrIP(ArrayList<ipAddr> arrIP) {
        this.arrIP = arrIP;
    }

    public void generateArr(int numHost) {
        arrIP = new ArrayList<>();
        int tope = numHost, initIP[], ipCen[];
        initIP = new int[4];
        ipCen = new int[4];
        for (int i = 0; i != 4; i++) {
            initIP[i] = (ipID[i] & maskS[i]);
        }
        for (int i = 0; i != 4; i++) {
            ipCen[i] = initIP[i];
        }
        tope -= 1;
        initIP[3] += 1;
        ipCen[3] += 1;
        arrIP.add(new ipAddr(ipCen));
        while (tope != 0) {
            ipCen = new int[4];
            if (initIP[3] == 0xff) {
                initIP[3] = 0x01;
                if (initIP[2] == 0xff) {
                    initIP[2] = 0x01;
                    if (initIP[1] == 0xff) {
                        initIP[1] = 0x01;
                        initIP[0] += 1;
                    } else {
                        initIP[1] += 1;
                    }
                } else {
                    initIP[2] += 1;
                }
            } else {
                initIP[3] += 1;
            }
            for (int i = 0; i != 4; i++) {
                ipCen[i] = initIP[i];
            }
            tope--;
            arrIP.add(new ipAddr(ipCen));
        }
    }

    @Override
    public String toString() {
        return ipID[0] + "." + ipID[1] + "." + ipID[2] + "." + ipID[3] + "/" + bits;
    }

}
