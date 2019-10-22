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
public class StudListTable {
    private final String link2;
    private Document document;
    private int total=0;
    private String std[];
    private String[][] stdList;
    private final String list = "\\d{6}";

    public StudListTable(String link2,int total){
        this.link2=link2;
        this.total=total;
        std=new String[total];
        stdList= new String[std.length][];
    }

    public String[][] comData(){
        try {
            int i=0;
            document = Jsoup.connect(link2).get();

            // get list of student
            Elements links = document.select("tr");
            for (Element link : links) {
                String theLink = link.text();
                Pattern p1 = Pattern.compile(list);   // the pattern to search for
                Matcher m1 = p1.matcher(theLink);
             if (m1.find()) {
               
                    std[i]=theLink;
                    i++;
                }
            }

            for(int j=0;j<std.length;j++){
                stdList[j]=std[j].split(" ",3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stdList;
    }

    public String[][] getList(){
        return stdList;
    }
}


