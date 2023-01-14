package UsefulClasses;

import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

public class DisplayButtonListener implements IODeviceEventListener {
    private	final SSD1306 myOled;
    private final Pin buttonPin;
    private	final Pin pinInput;
    private final Pin ledPin;
    // constructor
    public DisplayButtonListener(Pin ledPin, SSD1306 display, Pin buttonPin, Pin pinInput) {
        this.buttonPin = buttonPin;
        this.myOled = display;
        this.pinInput =	pinInput;
        this.ledPin = ledPin;

    }

    @Override
    public void onPinChange(IOEvent event) {
        if (event.getPin().getIndex() != buttonPin.getIndex()) {
            return;
            // to do: return;
        }
        try {
            // you can use this.ledPin in here.
            if(buttonPin.getValue() == 1){
                myOled.turnOn();
                myOled.getCanvas().clear();
                myOled.getCanvas().drawString(0,0, "Value " + String.valueOf(pinInput.getValue()));
                myOled.getCanvas().drawHorizontalLine(0,20, (int) (100*(pinInput.getValue()/1023.0)), MonochromeCanvas.Color.BRIGHT);
                myOled.display();
                ledPin.setValue(1);
            }
            else{
                myOled.getCanvas().clear();
                myOled.turnOff();
                ledPin.setValue(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    // These are empty methods (nothing in the curly braces)
    @Override
    public void onStart(IOEvent event) {


    }
    @Override
    public void onStop(IOEvent event) {}
    @Override
    public void onMessageReceive(IOEvent event, String
            message) {}
}