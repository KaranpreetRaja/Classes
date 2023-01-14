package eecs1021;

import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.IODevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;
import org.firmata4j.ssd1306.MonochromeCanvas;
import java.io.IOException;


public class LabGPart2 {
    public static void main(String[] args)
            throws InterruptedException, IOException
    {
        // Define your USB Connection
        String myUSB = "COM3";
        // Create a FirmataDevice object with a USB connection.
        IODevice theArduinoObject = new FirmataDevice(myUSB);
        // Start up the FirmataDevice object.
        theArduinoObject.start();
        theArduinoObject.ensureInitializationIsDone();
        // Create an I2C communication object b/w the Arduino chip and the OLED over I2C wires
        // 0x3C is the standard address over these wires for the SSD1306 (or SSD1515)
        // Then create an SSD1306 object using the I2C object with the right pixel size for the OLED
        I2CDevice i2cObject = theArduinoObject.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        // Initialize the OLED (SSD1306) object
        theOledObject.init();

        // Fill the OLED memory with something to draw.
        theOledObject.getCanvas().write("Karanpreet\n");
        theOledObject.getCanvas().write("Raja\n");
        theOledObject.getCanvas().write("218960617\n");

        // Update the OLED display (move data from memory onto the screen itself)
        theOledObject.display();
        // Wait.
        Thread.sleep(1000);

        // Stop the Grove or Arduino board.
        theArduinoObject.stop();

    }
}
