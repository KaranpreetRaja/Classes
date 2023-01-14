package UsefulClasses;

import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import java.io.IOException;

public class ButtonListener implements IODeviceEventListener {
    private final Pin ledPin;
    private final Pin buttonPin;
    // constructor
    public ButtonListener(Pin ledPin, Pin buttonPin) {
        this.buttonPin = buttonPin;
        this.ledPin = ledPin;
        // do the same for ledPin here.
    }
    // Define the four Listener methods.
    // Three are empty (not used)
    // Only onPinChange() is completed.
    // Define how onPinChange responds to an event.
    @Override
    public void onPinChange(IOEvent event) {
        // Return right away if the even isn't from the Button.
        if (event.getPin().getIndex() != buttonPin.getIndex()) {
            return;
            // to do: return;
        }

        // What is the current LED output value?
        // (use this.ledPin here and get its value)
        // Invert the LED.
        // If it's currently 1, make it 0. And vice versa.
        try {
            // you can use this.ledPin in here.
            if(ledPin.getValue() == 0){
                ledPin.setValue(1);
            }
            else{
                ledPin.setValue(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // These are empty methods (nothing in the curly braces)
    @Override
    public void onStart(IOEvent event) {}
    @Override
    public void onStop(IOEvent event) {}
    @Override
    public void onMessageReceive(IOEvent event, String
            message) {}
}