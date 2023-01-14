package eecs1021;
import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import java.io.IOException;

public class LabFPart1 {
    public static void main(String[] args)
            throws IOException
    {
        String myPort = "COM3";
        IODevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port
        try {
            myGroveBoard.start(); // start comms with board;
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();
        }
        catch (Exception ex) {
            System.out.println("couldn't connect to board.");
        }
        finally {
            var myLED = myGroveBoard.getPin(4);
            myLED.setMode(Pin.Mode.OUTPUT);
            // LED D4 on.
            myLED.setValue(1);
            // Pause for two seconds.
            try {
                Thread.sleep(2000);
            }
            catch(Exception ex){
                System.out.println("sleep error.");
            }
            // LED D4 off.
            myLED.setValue(0);
            myGroveBoard.stop(); // finish with the board.
            System.out.println("Board stopped.");
        }
    }

}
