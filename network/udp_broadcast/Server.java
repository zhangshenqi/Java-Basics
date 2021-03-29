import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A broadcast UDP server.
 * @author Shenqi Zhang
 *
 */
public class Server {
    /**
     * Prints the log.
     * @param message message
     */
    public static void printLog(DatagramPacket packet, String message) {
        StringBuilder sb = new StringBuilder("Receive message");
        sb.append("\n").append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Sender: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * A shell which receives messages.
     * @param args arguments
     */
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(7077);
            while (true) {
                byte[] buf = new byte[100];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                buf = packet.getData();
                String message = new String(buf, 0, packet.getLength());
                printLog(packet, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
