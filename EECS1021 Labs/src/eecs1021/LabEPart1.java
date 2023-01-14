package eecs1021;
import java.io.*;

import com.opencsv.CSVReader; // Import with Maven: com.opencsv:opencsv:3.8


public class LabEPart1 {
    public static void main(String[] args)
        throws IOException
        {
            final String fileName = "src/Files/Part1TextFile.txt";

            // open the file here.
            FileInputStream myFileObject = new FileInputStream(fileName);

            int myData;

            // loop through the data in the while below.
            while( (myData = myFileObject.read()) != -1){
                System.out.print((char)myData);     // the integer is cast to 8-bit char
            }

            myFileObject.close();

    }
}
