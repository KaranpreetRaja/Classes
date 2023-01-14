package UsefulClasses;

import org.firmata4j.Pin; // Firmata
import java.util.TimerTask; // Timer tasks.

public class ButtonTask extends TimerTask {
    private final Pin myPin;
    // The Constructor for ButtonTask
    public ButtonTask(Pin pin) {
        // Assign the externally-set "pin" to internal variable myPin
        this.myPin = pin;
    }
    @Override
    public void run() {
        // Print this each time TimerTask runs (e.g. once per 1000 ms.)
        System.out.println("value : " + myPin.getValue() );
    }
}
