package eecs1021;

import org.firmata4j.Pin;
import org.firmata4j.firmata.*; // Maven import Firmata4j & SLF4j on macOS & Windows
import org.firmata4j.IODevice; // You also need to import JSSC in using Windows.

import java.io.IOException;

public class practice {
    static final int A1	= 15;	//	Moisture Sensor
    public static void main(String[] args) throws InterruptedException, IOException {
        String arduinoUSBPort = "COM3";
        // Create a FirmataDevice object using arduinoUSBPort variable which stores port name
        IODevice ArduinoObject = new FirmataDevice(arduinoUSBPort);
        // Start up the FirmataDevice object
        ArduinoObject.start();

        // Make sure arduino object is initialized
        ArduinoObject.ensureInitializationIsDone();

        var xservomotor = ArduinoObject.getPin(8);
        xservomotor.setMode(Pin.Mode.SERVO);

        var yservomotor = ArduinoObject.getPin(7);
        yservomotor.setMode(Pin.Mode.SERVO);

        xservomotor.setValue(55);
        yservomotor.setValue(47);

        Thread.sleep(1000);

        xservomotor.setValue(90); //left
        yservomotor.setValue(80); //down


        Thread.sleep(1000);

        xservomotor.setValue(30); //right
        yservomotor.setValue(20); //up

        Thread.sleep(5000);
        xservomotor.setValue(55);
        yservomotor.setValue(47);


    }
}