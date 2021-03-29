import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * A broadcast UDP client.
 * @author Shenqi Zhang
 *
 */
public class Client {
    /**
     * Gets the list of broadcast addresses.
     * @return the list of broadcast addresses
     */
    public static List<InetAddress> getBroadcastAddresses() {
        List<InetAddress> broadcastList = new ArrayList<InetAddress>();
        Enumeration<NetworkInterface> interfaces;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isUp()) {
                    continue;
                }
                if (networkInterface.isLoopback()) {
                    continue;
                }
                networkInterface.getInterfaceAddresses().stream().map(a -> a.getBroadcast()).filter(Objects::nonNull).forEach(broadcastList::add);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return broadcastList;
    }
    
    /**
     * Prints the log.
     * @param message message
     */
    public static void printLog(DatagramPacket packet, String message) {
        StringBuilder sb = new StringBuilder("Broadcast message");
        sb.append("\n").append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Receiver: ").append(packet.getAddress().getHostAddress()).append(':').append(packet.getPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * A shell which broadcasts user-specified messages.
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        DatagramSocket socket = null;
        try {
            // In IPv4, 255.255.255.255 is the broadcast address of the local network.
            List<InetAddress> broadcastList = getBroadcastAddresses();
            String host = broadcastList.isEmpty() ? "255.255.255.255" : broadcastList.get(0).getHostAddress();
            InetAddress address = InetAddress.getByName(host);
            scanner = new Scanner(System.in);
            socket = new DatagramSocket();
            socket.setBroadcast(true);
            while (true) {
                System.out.print("Please Enter your request: ");
                String message = scanner.next();
                byte[] buf = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 7077);
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
