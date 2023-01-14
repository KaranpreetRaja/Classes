package eecs1021;
import UsefulClasses.CountTask;
import UsefulClasses.potTask;
import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import	org.firmata4j.firmata.FirmataDevice;
import	org.firmata4j.ssd1306.SSD1306;
import	java.io.IOException;
import	java.util.Timer;

public class LabGPart4 {
    //	Pin	definitions	(assuming	Nano	or	UNO)
    static final int A0	= 14;	//	Potentiometer
    static final int A2	= 16;	//	Sound
    static final int D6	= 6;	//	Button
    static final int D4	= 4;	//	LED
    static final byte I2C0 = 0x3C;	//	OLED	Display
    static final int duration = 1000;
    public static void	main(String[]	args)
            throws InterruptedException, IOException
    {
        var myUSBPort = "COM3"; // TO-DO : modify based on your computer setup.
        var device = new FirmataDevice(myUSBPort);
        device.start();
        device.ensureInitializationIsDone();
        // Set up the display (type, size ...)
        I2CDevice i2cObject = device.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.getCanvas().setTextsize(1);

        var button = device.getPin(14);
        button.setMode(Pin.Mode.INPUT);
        button.setMode(Pin.Mode.ANALOG);

        theOledObject.init();

        Timer timer = new Timer("Timer");
        var task = new potTask(theOledObject, button, timer, duration);
        timer.schedule(task, 0, 1000);
        //	Potentiometer…	use	getPin,	just	like	you	did	with	the	Button	in	the	prvious	lab.		But	for	A0	(or	14)

        //	Set	up	the OLED	 display	(type,	size	...)
        //	do	the	timer	thing	here,	just	as	you	did	in	the	previous	lab.
    }
}
