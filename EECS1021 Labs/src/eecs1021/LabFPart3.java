package eecs1021;

import UsefulClasses.LEDTask;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;
import java.util.Timer;

public class LabFPart3 {
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        var myUSBPort = "COM3"; // TO-DO : modify this!
        // Create a FirmataDevice, start it and ensure Init is done.
        IODevice myGroveBoard = new FirmataDevice(myUSBPort); // using the name of a port
        System.out.println("Board started.");
        myGroveBoard.ensureInitializationIsDone();
        // Use getPin() to tell us which pin the button is connected to.
        // Set the mode of this pin to Input.
        // Button is Digital Input 6 on the Grove board (D6)
        // This is exactly like with the LED in Part 1, except that
        // 1. The Button is on digital input 6 (not 4)
        // 2. It’s not Pin.Mode.OUTPUT … it’s INPUT.
        var myLED = myGroveBoard.getPin(4);
        myLED.setMode(Pin.Mode.OUTPUT);

        var button = myGroveBoard.getPin(6);
        button.setMode(Pin.Mode.INPUT);


        // make a new task for the button
        var task = new LEDTask(button, myLED);
        // Provide this task to the Timer.schedule() method
        // and set the time to “no delay” and 1000 ms. periods.
        // this is like in Lab C!
        Timer timer = new Timer("Timer");
        timer.schedule(task, 0, 1000);
    }
}
