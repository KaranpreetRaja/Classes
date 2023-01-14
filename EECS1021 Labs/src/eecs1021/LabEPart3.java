package eecs1021;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class LabEPart3 {
    public static void main(String[] args) throws IOException
    {
        try {
            final String fileName = "src/Files/single_waterstation2_data_feb6.csv";

            FileReader FileReaderObj = new FileReader(fileName);
            CSVReader ONHydrometricReader = new CSVReader(FileReaderObj, ',');

            String[] oneLineRecord;

            while ((oneLineRecord = ONHydrometricReader.readNext()) != null )
            {
                System.out.println(Arrays.toString((oneLineRecord)));
            }

            ONHydrometricReader.close();
            FileReaderObj.close();
        }
        catch(IOException ex){
            System.out.println("Warning! Exception Found!");
        }
    }
}
