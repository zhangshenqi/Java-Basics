import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        byte[] buf = new byte[100];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(7077);
            while (true) {
                socket.receive(packet);
                buf = packet.getData();
                String request = new String(buf, 0, packet.getLength());
                StringBuilder sb =  new StringBuilder("Receive Request").append("\n");
                sb.append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
                sb.append("Client: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
                sb.append("Message: ").append(request).append("\n");
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
        
    }
}
