/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package peb_validation_ver1;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
/**
 *
 * @author Z
 */
public class PeB_Validation_Ver1 {

    /**
     * @param args the command line arguments
     */
    
    public void validateCSVFile(){//start of validation
        String csvFilename="test.csv";/*Rename depending on where you put 
        the test file*/
        String Errors="";//string to record any errors
        CSVReader csvReader=null;
        try{
            csvReader=new CSVReader(new FileReader(csvFilename));
        }catch(Exception e){Errors+="File not found\n";}
            //reader
            String[] row=null;//temp storage of each row
            int ID=0,Gender=0,Affected=0,Deceased=0,xLink=0,Spouse=0,Consanguinity=0,Father=0,Mother=0,Twin=0,TwinType=0,i=0;
            String Alleles,ExtraInfo;
            try{
            while((row=csvReader.readNext())!=null){
                //This will check whether the integer values are indeed integers and that they have a proper value, where applicable
                try{
                    ID=Integer.parseInt(row[0]);//check ID
                }catch(Exception e){Errors+="Invalid data type for ID on row "+(i+1)+("\n");}
                
                try{
                    Gender=Integer.parseInt(row[1]);//check Gender
                }catch(Exception e){Errors+="Invalid data type for Gender on row "+(i+1)+("\n");}
                if(Gender<0||Gender>2){//ensure proper value
                    Errors+="Invalid value for Gender on row "+(i+1)+"\n";
                }
                
                try{
                    Affected=Integer.parseInt(row[2]);//check Affected
                }catch(Exception e){Errors+="Invalid data type for Affected on row "+(i+1)+("\n");}
                if(Affected!=0||Affected!=1){//ensure proper value
                    Errors+="Invalid value for Affected on row "+(i+1)+"\n";
                }
                
                try{
                    Deceased=Integer.parseInt(row[3]);//check Deceased
                }catch(Exception e){Errors+="Invalid data type for Deceased on row "+(i+1)+("\n");}
                if(Deceased!=0||Deceased!=1){//ensure proper value
                    Errors+="Invalid value for Deceased on row "+(i+1)+"\n";
                }
                
                try{
                    xLink=Integer.parseInt(row[4]);//check X-Linked
                }catch(Exception e){Errors+="Invalid data type for X-Linked on row "+(i+1)+("\n");}
                if(xLink!=0||xLink!=1){//ensure proper value
                    Errors+="Invalid value for X-Linked on row "+(i+1)+"\n";
                }
                
                try{
                    Spouse=Integer.parseInt(row[7]);//check Spouse
                }catch(Exception e){Errors+="Invalid data type for Spouse on row "+(i+1)+("\n");}
                
                try{
                    Consanguinity=Integer.parseInt(row[8]);//check Consanguinity
                }catch(Exception e){Errors+="Invalid data type for Consanguinity on row "+(i+1)+("\n");}
                if(Consanguinity!=0||Consanguinity!=1){//ensure proper value
                    Errors+="Invalid value for Consanguinity on row "+(i+1)+"\n";
                }
                
                try{
                    Father=Integer.parseInt(row[9]);//check Father
                }catch(Exception e){Errors+="Invalid data type for Father on row "+(i+1)+("\n");}
                
                try{
                    Mother=Integer.parseInt(row[10]);//check Mother
                }catch(Exception e){Errors+="Invalid data type for Mother on row "+(i+1)+("\n");}
                
                try{
                    Twin=Integer.parseInt(row[11]);//check Twin
                }catch(Exception e){Errors+="Invalid data type for Twin on row "+(i+1)+("\n");}
                
                try{
                    TwinType=Integer.parseInt(row[12]);//check Twin Type
                }catch(Exception e){Errors+="Invalid data type for Twin Type on row "+(i+1)+("\n");}
                if(TwinType!=0||TwinType!=1){//ensure proper value
                    Errors+="Invalid value for Twin Type on row "+(i+1)+"\n";
                }
                
                i++;//increment row counter
            }
            /*Can change the code to print out things if it ever fails to catch something
             Storing the values will be needed to verify relationships, unless you want a seperate code to do that
             I can add that to this if you'd rather do that, though I'll need to reinstate the Vectors for ID's and such to check for mismatches*/
        }catch(Exception e){Errors+="File not used";}
        //throws exception on failure to find file
        if(!Errors.equals("")){
            System.out.println(Errors);
        }
    }
    
    public PeB_Validation_Ver1(){
        validateCSVFile();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new PeB_Validation_Ver1();
    }
}
