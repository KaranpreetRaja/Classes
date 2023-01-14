package UsefulClasses;

import	org.firmata4j.Pin;
import	org.firmata4j.ssd1306.MonochromeCanvas;
import	org.firmata4j.ssd1306.SSD1306;
import	java.io.IOException;
import	java.util.Timer;
import	java.util.TimerTask;

public class potTask extends TimerTask {
    private	int	duration;
    private	final SSD1306 myOled;
    private	final Pin pinInput;
    private	final Timer	myTimer;
    //	class	constructor.
    public	potTask(SSD1306	display, Pin pin, Timer	timer, int duration) {
        this.myOled = display;
        this.pinInput =	pin;
        this.myTimer = timer;
        this.duration = duration;
    }


    @Override
    public void run() {
        //	note	you	need	to	convert	the	int	to	String.
        System.out.println("its working");
        System.out.println(100*(pinInput.getValue()/1023.0));

        myOled.getCanvas().clear();
        myOled.getCanvas().drawString(0,0, "Value " + String.valueOf(pinInput.getValue()));
        myOled.getCanvas().drawHorizontalLine(0,20, (int) (100*(pinInput.getValue()/1023.0)), MonochromeCanvas.Color.BRIGHT);
        myOled.display();
        //	print	to	the	Java	console
        //	First,	write	the Potentiometer	value.			Attach a	“drawString()”	method	to	getCanvas().
        //Next,	erase	the	previous horizontal	 line	by	applying	"DARK"
        //		Now,	draw	a	white	line	that	is	proportional	to	the	potentiometer	value.
        //	run	the	display()	method.
    }
}