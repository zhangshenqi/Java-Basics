import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = null;
        try {
            InetAddress address = InetAddress.getByName("localhost");
            socket = new DatagramSocket();
            scanner = new Scanner(System.in);
            while (true) {
                String request = scanner.next();
                if (request.trim().toLowerCase().equals("kill")) {
                    break;
                }
                byte[] buf = request.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 7077);
                StringBuilder sb =  new StringBuilder("Send Request").append("\n");
                sb.append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
                sb.append("Server: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
                sb.append("Message: ").append(request).append("\n");
                System.out.println(sb.toString());
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
