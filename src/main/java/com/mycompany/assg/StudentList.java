/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author USER
 */
public class StudentList {
    private final String link2;
    private Document doc1;
    private String[] acc;
    private String[][] acc1;
    private int total;
    private final String comment = "\\d{5,6}";
    private String[][] acc2;
    StudentList(String link2,int total){
        this.link2=link2;
        this.total=total;
        acc=new String[total];
        acc1=new String[acc.length][];
    }
    public String[][] comData(){
        try {

            int i=0;
            doc1 = Jsoup.connect(link2).get();


            // get students who submitt github account
            Elements links = doc1.select("p");
                for (Element link : links) {
                    String theLink = link.text();
                     Pattern p1 = Pattern.compile(comment);   // the pattern to search for
                     Matcher m1 = p1.matcher(theLink);
             if (m1.find()) {
                    
                        acc[i]=theLink.trim();
                        i++;
                    }
            }

            for(int j=0;j<acc.length;j++){
                acc1[j]=acc[j].trim().split("Matric:|Name:|Link:|Matric :|Name :|Link :|matrix :|name :|link:|Matric No :|Name|Matric no:");
            }
            for(int a=0;a<acc1.length;a++){
                for(int b=0;b<acc1[a].length;b++){
                    if((b+1)<acc1[a].length){
                        acc1[a][b]=acc1[a][b+1];
                    }
                }
            }

            for(int o=0;o<acc1.length;o++){
                if(acc1[o][0].length()>8){
                    if (acc1[o][1].length()>=5 && acc1[o][1].length()<=8){
                        String str =acc1[o][0];
                        acc1[o][0]=acc1[o][1];
                        acc1[o][1]=str;
                    }
                }
            }

            for(int x=0;x<acc1.length;x++){
                for(int y=0;y<acc1[x].length;y++){
                    acc1[x][y]=acc1[x][y].trim();
                }
            }

            acc2=new String[acc1.length][acc1[0].length-1];
            for(int x=0;x<acc1.length;x++){
                for(int y=0;y<(acc1[x].length-1);y++){
                    acc2[x][y]=acc1[x][y];
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc2;
    }

    public String[][] getAcc(){
        return acc2;
    }
}

