import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A unicast UDP client.
 * @author Shenqi Zhang
 *
 */
public class Client {
    /**
     * Prints the log.
     * @param sendRequest true if this is for sending a request
     * @param packet packet
     * @param message message
     */
    public static void printLog(boolean sendRequest, DatagramPacket packet, String message) {
        StringBuilder sb = new StringBuilder();
        if (sendRequest) {
            sb.append("Send request").append("\n");
        } else {
            sb.append("Receive response").append("\n");
        }
        sb.append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Server: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * A shell which sends user-specified requests and receives responses.
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        DatagramSocket socket = null;
        try {
            InetAddress address = InetAddress.getByName("localhost");
            scanner = new Scanner(System.in);
            socket = new DatagramSocket();
            while (true) {
                System.out.print("Please Enter your request: ");
                String request = scanner.next();
                byte[] buf = request.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 7077);
                printLog(true, packet, request);
                socket.send(packet);
                
                buf = new byte[100];
                packet.setData(buf);
                socket.receive(packet);
                String response = new String(packet.getData());
                printLog(false, packet, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            socket.close();
        }
    }
}
