/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package readcsv;

import au.com.bytecode.opencsv.CSVReader;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;




/**
 *
 * @author war
 */
public class ReadCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
    String csvFilename = "D:\\sample.csv";
    CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
    String[] row = null;
    while((row = csvReader.readNext()) != null) {
        System.out.println(row[0]
              + " , " + row[1]
              + " ,  " + row[2]);
}
//...
    csvReader.close();
    }
    
    }

