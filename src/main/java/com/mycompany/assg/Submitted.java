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
public class Submitted extends Thread{
     String submit[][];
    Submitted(String[][] submit){
        this.submit=submit;
    }

    
     @Override
    public void run() {
        System.out.println("List of all students who have submitted the GitHub account:");
        System.out.println("");
        System.out.println("|No |Matric | Name                                | GitHub Link                       |");
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        for(int x=0;x<submit.length;x++){
                System.out.printf("|%-3s|%-7s|%-37s|%-35s|\n",x+1,submit[x][0],submit[x][1],submit[x][2]);
        }
        System.out.println("|---|-------|-------------------------------------|-----------------------------------|");
        System.out.println("");
    }
}


