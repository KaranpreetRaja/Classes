/*  * Original coding by Richard Robinson and James Andrew Smith; York University*/
package UsefulClasses;

import com.fazecast.jSerialComm.SerialPort;


public class SerialPortService{
        private SerialPortService() {}

        public static SerialPort getSerialPort(String portDescriptor) {
            var sp = SerialPort.getCommPort(portDescriptor);

            sp.setComPortParameters(9600, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

            var hasOpened = sp.openPort();
            if (!hasOpened) {
                throw new IllegalStateException("Failed to open port.");
            }

            return sp;
        }
}
