/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csvobject;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author war
 */
public class CSVObject {
    private String entityID;
    private String entityGender;
    private String entityAffected;
    private String entityLifeStatus;
    private String entityAlleles;
    private String entityInformation;
    
    
    public String getentityID() {
        return entityID;
    }
 
    public void setentityID(String entityID) {
        this.entityID = entityID;
    }
 
    public String getentityGender() {
        return entityGender;
    }
 
    public void setentityGender(String entityGender) {
        this.entityGender = entityGender;
    }

    
    public static void main(String[] args) throws FileNotFoundException {
        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
        strat.setType(CSVObject.class);
        String[] columns = new String[] {"entityID", "entityGender"}; // the fields to bind do in your JavaBean
        strat.setColumnMapping(columns);
 
        CsvToBean csv = new CsvToBean();
 
        String csvFilename = "D:\\Netbeans Projects\\CSVObject\\sample.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
 
        List list = csv.parse(strat, csvReader);
        for (Object object : list) {
            CSVObject entity = (CSVObject) object;
            System.out.println(entity.getentityID());
            System.out.println(entity.getentityGender());
}
    }
    
    
    
    
}
