/* Two maven operations:
 * 1. com.fazecast:jSerialComm:2.9.1 for jSerialComm
 * 2. org.apache.commons:commons-lang3:3.3.2 (for StringUtils chop)
 *
 * Original coding by Richard Robinson and James Andrew Smith; York University
 */
package UsefulClasses;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortMessageListenerWithExceptions;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;

public class DataController implements SerialPortMessageListenerWithExceptions {
    private static final byte[] DELIMITER = new byte[]{'\n'};



    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() != SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            return;
        }

        //var data = serialPortEvent.getReceivedData();
        // Bytes received: [0] is MSB last is [CR]
        var data = serialPortEvent.getReceivedData();
        var time = System.currentTimeMillis();

        String dataString;
        dataString = null;
        try {
            dataString = new String(data, "UTF-8");
            dataString  = StringUtils.chop(dataString);  // remove the carriage return (CR)
        }
        catch(Exception e)
        {
            System.out.println("error");
        }

        // Convert String into Integer
        assert dataString != null;
        int dataInteger = Integer.valueOf(dataString);

        // Print out the received data as both integer and String.
        System.out.println("Data received: " + dataInteger + " ... " + dataString);
    }

    @Override
    public void catchException(Exception e) {
        e.printStackTrace();
    }

    @Override
    public byte[] getMessageDelimiter() {
        return DELIMITER;
    }

    @Override
    public boolean delimiterIndicatesEndOfMessage() {
        return true;
    }
}
