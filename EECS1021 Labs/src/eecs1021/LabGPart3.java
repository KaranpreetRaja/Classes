package eecs1021;

import UsefulClasses.CountTask;
import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import java.util.Timer;


public class LabGPart3 {
    static final byte I2C0 = 0x3C; // OLED Display
    public static void main(String[] args) throws IOException, InterruptedException {
        var myUSBPort = "COM3"; // TO-DO : modify based on your computer setup.
        var device = new FirmataDevice(myUSBPort);
        device.start();
        device.ensureInitializationIsDone();
        // Set up the display (type, size ...)
        I2CDevice i2cObject = device.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        var task = new CountTask(theOledObject);
        Timer timer = new Timer("Timer");
        timer.schedule(task, 0, 1000);
    }
}
