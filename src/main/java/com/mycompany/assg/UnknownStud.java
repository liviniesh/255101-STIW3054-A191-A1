/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg;

/**
 *
 * @author USER
 */
public class UnknownStud extends Thread {
    String unknown[][];
    UnknownStud(String unknown[][]){
        this.unknown=unknown;

    }
    @Override
    public void run() {
        System.out.println("List of all unknown students have submitted the GitHub account:");
        System.out.println("");
        System.out.println("|No |Matric | Name                                | GitHub Link                       |");
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        for(int x=0;x<unknown.length;x++){
            System.out.printf("|%-3s|%-7s|%-37s|%-35s|\n",x+1,unknown[x][0],unknown[x][1],unknown[x][2]);
        }
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        System.out.println("");
    }
}
