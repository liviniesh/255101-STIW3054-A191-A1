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
public class NotSubmitted extends Thread{
    String noSub[][];

    NotSubmitted(String noSub[][]){
        this.noSub=noSub;

    }

    @Override
    public void run() {
        System.out.println("List of all students who have not submitted the GitHub account:");
        System.out.println("");
        System.out.println("|No |Matric | Name                                |");
        System.out.println("|---|-------|-------------------------------------|");
        for(int x=0;x<noSub.length;x++){
            System.out.printf("|%-3s|%-7s|%-37s|\n",x+1,noSub[x][1],noSub[x][2]);
        }
        System.out.println("|---|-------|-------------------------------------|");
        System.out.println("");
    }
}