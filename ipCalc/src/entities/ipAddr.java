/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author developercrack
 */
public class ipAddr {

    private int ip[];

    public ipAddr(int[] ip) {
        this.ip = ip;
    }

    public int[] getIp() {
        return ip;
    }

    public void setIp(int[] ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3];
    }

}
