import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A unicast UDP server.
 * @author Shenqi Zhang
 *
 */
public class Server {
    /**
     * Prints the log.
     * @param receiveRequest true if this is for receiving a request
     * @param packet packet
     * @param message message
     */
    public static void printLog(boolean receiveRequest, DatagramPacket packet, String message) {
        StringBuilder sb = new StringBuilder();
        if (receiveRequest) {
            sb.append("Receive request").append("\n");
        } else {
            sb.append("Send response").append("\n");
        }
        sb.append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Server: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * A shell which receives requests and sends user-specified responses.
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        DatagramSocket socket = null;
        try {
            scanner = new Scanner(System.in);
            socket = new DatagramSocket(7077);
            while (true) {
                byte[] buf = new byte[100];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                buf = packet.getData();
                String request = new String(buf, 0, packet.getLength());
                printLog(true, packet, request);
                
                System.out.print("Please Enter your response: ");
                String response = scanner.next();
                buf = response.getBytes();
                packet.setData(buf);
                printLog(false, packet, response);
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
