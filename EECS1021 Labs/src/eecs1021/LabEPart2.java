package eecs1021;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;


public class LabEPart2 {
    public static void main(String[] args) throws IOException
    {
        try {
            final String fileName = "src/Files/Part2_CO2_DataLog_Modified_short.csv";

            var theAirQualityFile = new File(fileName);
            List<String> csvRows = Files.readAllLines(theAirQualityFile.toPath());
            ArrayList<String> arrLst = new ArrayList<String>();
            arrLst.addAll(csvRows);

            int size = arrLst.size();
            double average;
            double sum = 0;
            int i;
            for (i = 0; i < size; i++) {
                sum += Double.parseDouble(arrLst.get(i).split(",")[5]);
            }
            average = sum / i;
            System.out.println("The average is: " + average);
        }
        catch(IOException ex){
            System.out.println("Warning! Exception Found!");
        }
    }
}
