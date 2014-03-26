/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package writeexceldemo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author war
 */
public class WriteExcelDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating a new workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        //Create a blank sheet in that workbook
        XSSFSheet sheet = workbook.createSheet("First Example");
        
        //Lets write our first sheet with example data
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Darius", "Carrier"});
        data.put("3", new Object[] {2, "Andrew", "Phillips"});
        data.put("4", new Object[] {3, "Bryan", "Fleming"});
        data.put("5", new Object[] {4, "Cody", "McCarter"});
        
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("PeBExample.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("PeBExample.xlsx written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
