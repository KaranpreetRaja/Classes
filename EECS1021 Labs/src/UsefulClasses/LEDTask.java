package UsefulClasses;

import org.firmata4j.Pin; // Firmata

import java.io.IOException;
import java.util.TimerTask; // Timer tasks.

public class LEDTask extends TimerTask {
    private final Pin myButton;
    private final Pin myLED;
    private int delay;
    // The Constructor for LEDTask
    public LEDTask(Pin pin, Pin pin2) {
        // Assign the externally-set "pin" to internal variable myPin
        this.myButton = pin;
        this.myLED = pin2;
    }
    @Override
    public void run() {
        // Print this each time TimerTask runs (e.g. once per 1000 ms.)
        System.out.println("value : " + myButton.getValue() );
        if(myButton.getValue() == 1){
            this.delay = 1000;
        }
        else{
            this.delay = 2000;
        }

        // now we can use the delay variable to flash the LED for that duration of time

        try {
            myLED.setValue(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Pause for two seconds.
        try {
            Thread.sleep(delay);
        }
        catch(Exception ex){
            System.out.println("sleep error.");
        }
        // LED D4 off.
        try {
            myLED.setValue(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        }
        catch(Exception ex){
            System.out.println("sleep error.");
        }

    }
}