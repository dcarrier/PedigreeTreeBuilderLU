/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package writecsv;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author war
 */
public class WriteCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String csv = "D:\\singleline.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
 
        String [] country = "India,China,United States".split(",");
 
        writer.writeNext(country);
 
        writer.close();
        /////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////
        
        String csv2 = "D:\\multiline.csv";
        CSVWriter writer2 = new CSVWriter(new FileWriter(csv2));
 
        List<String[]> data = new ArrayList<String[]>();
        data.add(new String[] {"India", "New Delhi"});
        data.add(new String[] {"United States", "Washington D.C"});
        data.add(new String[] {"Germany", "Berlin"});
 
        writer2.writeAll(data);
 
        writer2.close();
    }
    
}
