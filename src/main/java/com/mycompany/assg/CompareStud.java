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
public class CompareStud {
 private String studacc[][];
    private String studList[][];
    private String stdUnknown[][];
    private String stdUnknown1[][];
    private String stdCompare[][];
    int i=0;
    int j=0;

    CompareStud(String studacc[][],String studList[][]){
        this.studacc=studacc;
        this.studList=studList;
    }

    public void check2(){
        ArrayList<String> compare = new ArrayList<>();
        ArrayList<String> compare1 = new ArrayList<>();
        ArrayList<String> unk = new ArrayList<>();

        for(int x=0;x<studacc.length;x++){
            compare.add(studacc[x][0]);
        }
        for(int x=0;x<studList.length;x++){
            if(compare.contains(studList[x][1]))
                compare.remove(studList[x][1]);
        }
        stdUnknown= new String[compare.size()][];
        for(int x=0;x<studacc.length;x++){
            if(compare.contains(studacc[x][0])){
                stdUnknown[i]=studacc[x];
                i++;
            }
        }

        for(int x=0;x<stdUnknown.length;x++){
            compare1.add(stdUnknown[x][1]);
        }
        for(int x=0;x<studList.length;x++){
            if(compare1.contains(studList[x][2])){
                compare1.remove(studList[x][2]);
            }

        }
        stdUnknown1= new String[compare1.size()][];
        for(int x=0;x<stdUnknown.length;x++){
            if(compare1.contains(stdUnknown[x][1])){
                stdUnknown1[j]=stdUnknown[x];
                j++;
            }
        }
        stdCompare=new String[(studacc.length-compare1.size())][];
        int k=0;
        for(int x=0;x<studacc.length;x++){
            if(!compare1.contains(studacc[x][1])){
                stdCompare[k]=studacc[x];
                k++;
            }
        }
    }

    public String[][] getUnknown(){
        return stdUnknown1;
    }

    public String[][] getCompare(){
        return stdCompare;
        
    }
}
