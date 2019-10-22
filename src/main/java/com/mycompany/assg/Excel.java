/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author USER
 */
public class Excel {
    String[][] ex;
    String[][] ex1;
    String[][] ex2;
    String[] header1={"Matric","Name","Link"};
    String[] header2={"Matric","Name"};
    Excel(String[][] ex,String[][] ex1,String[][] ex2){
        this.ex=ex;
        this.ex1=ex1;
        this.ex2=ex2;
    }
    public void run() {
        XSSFWorkbook workbook1 = new XSSFWorkbook();
        XSSFSheet wxsheet = workbook1.createSheet("StudentSubmit");
        XSSFSheet wxsheet1 = workbook1.createSheet("StudentNotSubmit");
        XSSFSheet wxsheet2 = workbook1.createSheet("UnknownStudent");

        //write to first sheet
        int rowCount1 = 0;
        int column = 0;
        Row row1 = wxsheet.createRow(++rowCount1);
        for (int x=0;x<header1.length;x++) {

                Cell cell1 = row1.createCell(++column);
                cell1.setCellValue((String) header1[x]);

        }


        for (int x=0;x<ex.length;x++) {
            Row row = wxsheet.createRow(++rowCount1);

            int columnCount = 0;

            for (int y=0;y<ex[x].length;y++) {
                Cell cell1 = row.createCell(++columnCount);
                    cell1.setCellValue((String) ex[x][y]);
                wxsheet.autoSizeColumn(y);

            }
        }

        //write to second sheet
        int column1 = 0;
        int rowCount2=0;
        Row row2 = wxsheet1.createRow(++rowCount2);
        for (int x=0;x<header2.length;x++) {

            Cell cell1 = row2.createCell(++column1);
            cell1.setCellValue((String) header2[x]);
        }
        for (int x=0;x<ex1.length;x++) {
            Row row = wxsheet1.createRow(++rowCount2);

            int columnCount = 0;

            for (int y=1;y<ex1[x].length;y++) {
                Cell cell1 = row.createCell(++columnCount);
                cell1.setCellValue((String) ex1[x][y]);
                wxsheet1.autoSizeColumn(y);
            }
        }

        //write to third sheet
        int rowCount3 = 0;
        int column2 = 0;
        Row row3 = wxsheet2.createRow(++rowCount3);
        for (int x=0;x<header1.length;x++) {

            Cell cell1 = row3.createCell(++column2);
            cell1.setCellValue((String) header1[x]);
        }


        for (int x=0;x<ex2.length;x++) {
            Row row = wxsheet2.createRow(++rowCount3);

            int columnCount = 0;

            for (int y=0;y<ex2[x].length;y++) {
                Cell cell1 = row.createCell(++columnCount);
                cell1.setCellValue((String) ex2[x][y]);
                wxsheet2.autoSizeColumn(y);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("Assignment1.xlsx")) {
            workbook1.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
