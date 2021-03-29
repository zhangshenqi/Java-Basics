import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A multicast UDP client.
 * @author Shenqi Zhang
 *
 */
public class Client {
    /**
     * Prints the log.
     * @param message message
     */
    public static void printLog(DatagramPacket packet, String message) {
        StringBuilder sb = new StringBuilder("Multicast message");
        sb.append("\n").append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Receiver: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * A shell which multicasts user-specified messages.
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        DatagramSocket socket = null;
        try {
            // In IPv4, any address between 224.0.0.0 and 239.255.255.255 can be used as a multicast address.
            InetAddress group = InetAddress.getByName("225.0.0.0");
            scanner = new Scanner(System.in);
            socket = new DatagramSocket();
            socket.setBroadcast(true);
            while (true) {
                System.out.print("Please Enter your request: ");
                String message = scanner.next();
                byte[] buf = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 7077);
                printLog(packet, message);
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            socket.close();
        }
    }
}
