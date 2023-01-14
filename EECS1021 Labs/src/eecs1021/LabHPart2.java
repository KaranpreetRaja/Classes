package eecs1021;
import UsefulClasses.DisplayButtonListener;
import UsefulClasses.Pins;
import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

public class LabHPart2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        var arduinoObject = new FirmataDevice("COM3");
        arduinoObject.start();
        arduinoObject.ensureInitializationIsDone();

        I2CDevice i2cObject = arduinoObject.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.getCanvas().setTextsize(1);

        theOledObject.init();

        var potentiometer = arduinoObject.getPin(14);
        potentiometer.setMode(Pin.Mode.INPUT);
        potentiometer.setMode(Pin.Mode.ANALOG);

        var myLED = arduinoObject.getPin(4);
        myLED.setMode(Pin.Mode.OUTPUT);


        var button = arduinoObject.getPin(Pins.D6);
        button.setMode(Pin.Mode.INPUT);

        arduinoObject.addEventListener(new DisplayButtonListener(myLED, theOledObject, button, potentiometer));
    }

}
