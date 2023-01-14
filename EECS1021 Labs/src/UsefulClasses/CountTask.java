package UsefulClasses;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import java.util.TimerTask;

public class CountTask extends TimerTask {
    private int countValue = 10;
    private final SSD1306 theOledObject;
    // Constructor for CountTask
    public CountTask(SSD1306 aDisplayObject){
        theOledObject = aDisplayObject;
    }
    @Override
    public void run() {
        while (countValue >= 0){
            theOledObject.init();
            // Fill the OLED memory with something to draw.
            theOledObject.getCanvas().clear(); // clear contents first.
            theOledObject.getCanvas().setTextsize(4);
            theOledObject.getCanvas().setCursor(0,0);
            theOledObject.getCanvas().write(countValue + "\n");
            // Update the OLED display (move data from memory onto the screen itself)
            theOledObject.display();
            countValue --;
            // Wait.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            theOledObject.turnOff();

            // Stop the Grove or Arduino board.

            // draw the String…
            // Update the OLED display (move data from memory onto the screen itself)
            // Update your count variable.
        }
    }
}
