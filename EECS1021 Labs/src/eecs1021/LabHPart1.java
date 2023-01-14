package eecs1021;
import UsefulClasses.ButtonListener;
import UsefulClasses.Pins;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import java.io.IOException;

public class LabHPart1 {
    public static void main(String[] args) throws
            IOException, InterruptedException {
        /* Initialize the Board */
        var arduinoObject = new FirmataDevice("COM3");
        /* Initialize the LED & Button pins */
        // 1. Assign memory location to the object LED object
        arduinoObject.start();
        arduinoObject.ensureInitializationIsDone();
        var myLED = arduinoObject.getPin(Pins.D4);
        myLED.setMode(Pin.Mode.OUTPUT);
        // 2. Fill the object.
        // 1. Assign memory location to the button object
        var button = arduinoObject.getPin(Pins.D6);
        button.setMode(Pin.Mode.INPUT);
        // 2. Fill the object.

        // Add an Event Listener to the board.
        // Pass the ledObject and buttonObject to the Listener.
        // Version 1: longer

        //ButtonListener theButtonListener = new ButtonListener(ledObject,buttonObject);
        //arduinoObject.addEventListener(theButtonListener);

        // Version 2: shorter
        arduinoObject.addEventListener(new ButtonListener(myLED, button));
    }
}
