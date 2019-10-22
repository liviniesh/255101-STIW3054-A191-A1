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
public class StudSubmitted {
 private String link2;
    private Document doc2;
    private int total=0;
    private final String submit = "\\d{5,6}";

    StudSubmitted(String link2){
        this.link2=link2;
    }

    public int comStud(){
        try {
            doc2 = Jsoup.connect(link2).get();

        // get students who submitt github account
        Elements links = doc2.select("p");
        for (Element link : links) {
            String theLink = link.text();
            Pattern p1 = Pattern.compile(submit);   // the pattern to search for
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
