package eecs1021;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class LabEPart4 {
    public static void main(String[] args) throws IOException
    {
        try {
            final String fileName = "src/Files/ON_04FB001_daily_hydrometric_MODIFIED.csv";
            final int column2read = 7;

            FileReader FileReaderObj = new FileReader(fileName);
            CSVReader ONHydrometricReader = new CSVReader(FileReaderObj, ',');

            String[] oneLineRecord;
            double average;
            double sum = 0;
            int count = 0;

            while ((oneLineRecord = ONHydrometricReader.readNext()) != null )
            {
                sum += Double.parseDouble(oneLineRecord[column2read]);
                count++;
            }
            average = sum/count;
            System.out.println("The average Discharge Rate is " + average);

            ONHydrometricReader.close();
            FileReaderObj.close();
        }
        catch(IOException ex){
            System.out.println("Warning! Exception Found!");
        }
    }
}
