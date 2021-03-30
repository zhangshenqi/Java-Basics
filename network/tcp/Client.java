import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A TCP client.
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
    public static void printLog(boolean sendRequest, Socket socket, String message) {
        StringBuilder sb = new StringBuilder();
        if (sendRequest) {
            sb.append("Send request").append("\n");
        } else {
            sb.append("Receive response").append("\n");
        }
        sb.append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Client: ").append(socket.getLocalAddress().getHostAddress()).append(':').append(socket.getLocalPort()).append("\n");
        sb.append("Server: ").append(socket.getInetAddress().getHostAddress()).append(':').append(socket.getPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * A shell which sends user-specified requests and receives responses.
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        Socket socket = null;
        try {
            scanner = new Scanner(System.in);
            socket = new Socket("localhost", 7077);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader intputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(intputStreamReader);
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            while (true) {
                System.out.print("Please Enter your request: ");
                String request = scanner.next();
                printLog(true, socket, request);
                bufferedWriter.write(request);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                
                String response = bufferedReader.readLine();
                printLog(false, socket, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            try {
                bufferedReader.close();
                bufferedWriter.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
