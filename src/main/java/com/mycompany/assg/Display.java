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
public class Display extends Thread {

    String submit[][];
    String noSub[][];
    String unknown[][];

    Display(String[][] submit, String noSub[][], String unknown[][]) {
        this.submit = submit;
        this.noSub = noSub;
        this.unknown = unknown;
    }

    @Override
    public void run() {
        System.out.println("List of all students who have submitted the GitHub account:");
        System.out.println("");
        System.out.println("|No |Matric | Name                                | GitHub Link                       |");
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        for (int x = 0; x < submit.length; x++) {
            System.out.printf("|%-3s|%-7s|%-37s|%-35s|\n", x + 1, submit[x][0], submit[x][1], submit[x][2]);
        }
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        System.out.println("");

        System.out.println("List of all students who have not submitted the GitHub account:");
        System.out.println("");
        System.out.println("|No |Matric | Name                                |");
        System.out.println("|---|-------|-------------------------------------|");
        for (int y = 0; y < noSub.length; y++) {
            System.out.printf("|%-3s|%-7s|%-37s|\n", y + 1, noSub[y][1], noSub[y][2]);
        }
        System.out.println("|---|-------|-------------------------------------|");
        System.out.println("");

        System.out.println("List of all unknown students have submitted the GitHub account:");
        System.out.println("");
        System.out.println("|No |Matric | Name                                | GitHub Link                       |");
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        for (int z = 0; z < unknown.length; z++) {
            System.out.printf("|%-3s|%-7s|%-37s|%-35s|\n", z + 1, unknown[z][0], unknown[z][1], unknown[z][2]);
        }
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        System.out.println("");
    }
}
