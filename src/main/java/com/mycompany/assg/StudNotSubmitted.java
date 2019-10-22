/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
public class StudNotSubmitted {
  private String studacc[][];
    private String stdList[][];
    private String nosub[][];
    private String nosub1[][];
    private int i=0;
    private int j=0;

    StudNotSubmitted(String studacc[][],String studList[][]){
        this.studacc=studacc;
        this.stdList=studList;
    }

    public String[][] compare(){
        ArrayList<String> comp = new ArrayList<>();
        ArrayList<String> comp1 = new ArrayList<>();

        for(int x=0;x<stdList.length;x++){
            comp.add(stdList[x][1]);
        }
        for(int x=0;x<studacc.length;x++){
            if(comp.contains(studacc[x][0]))
                comp.remove(studacc[x][0]);
        }
        nosub= new String[comp.size()][];
        for(int x=0;x<stdList.length;x++){
            if(comp.contains(stdList[x][1])){
                nosub[i]=stdList[x];
                i++;
            }
        }

        for(int x=0;x<nosub.length;x++){
            comp1.add(nosub[x][2]);
        }
        for(int x=0;x<studacc.length;x++){
            if(comp1.contains(studacc[x][1]))
                comp1.remove(studacc[x][1]);
        }
        nosub1= new String[comp1.size()][];
        for(int x=0;x<nosub.length;x++){
            if(comp1.contains(nosub[x][2])){
                nosub1[j]=nosub[x];
                j++;
            }
            
        }

        return nosub1;
    }

    public String[][] getNotsub(){
        return nosub1;
    }
}
