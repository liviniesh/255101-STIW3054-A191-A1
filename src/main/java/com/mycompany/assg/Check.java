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
public class Check {
    final String link = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
    final String link2 = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
    NoStud nostud;
    StudSubmitted nosub;
    StudListTable studlist;
    StudentList studacc;
    StudNotSubmitted notsb;
    Display s1;
    Excel e1;
    CompareStud compare;

    public void run() {
        nostud = new NoStud(link);
        nosub = new StudSubmitted(link2);
        studlist = new StudListTable(link, nostud.comStud());
        studacc = new StudentList(link2, nosub.comStud());
        studacc.comData();
        studlist.comData();
        compare = new CompareStud(studacc.getAcc(), studlist.getList());
        compare.check2();
        notsb = new StudNotSubmitted(compare.getCompare(), studlist.getList());
        s1 = new Display(compare.getCompare(), notsb.compare(), compare.getUnknown());
        e1 = new Excel(compare.getCompare(), notsb.getNotsub(), compare.getUnknown());
        s1.run();
        e1.run();
    }
}
