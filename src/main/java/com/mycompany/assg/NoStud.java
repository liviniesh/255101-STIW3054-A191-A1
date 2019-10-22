/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author USER
 */
public class NoStud {
  private String link;
    private Document doc1;
    private int total=0;
    private final String noSubmit = "\\d{6}";

    NoStud(String link){
        this.link=link;
    }

    public int comStud(){
        try {
            doc1 = Jsoup.connect(link).get();
        // get students who submitt github account
        Elements links = doc1.select("tr");
        for (Element link : links) {
            String theLink = link.text();
            Pattern p1 = Pattern.compile(noSubmit);   // the pattern to search for
            Matcher m1 = p1.matcher(theLink);
             if (m1.find()) {
           
                total++;
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
}
  
