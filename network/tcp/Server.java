import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A TCP server.
 * @author Shenqi Zhang
 *
 */
public class Server implements Runnable {
    /**
     * Client socket.
     */
    private Socket clientSocket;
    
    /**
     * Constructs a server with a specified client socket.
     * @param clientSocket specified client socket
     */
    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    /**
     * Prints the log.
     * @param receiveRequest true if this is for receiving a request
     * @param packet packet
     * @param message message
     */
    public static void printLog(boolean receiveRequest, Socket socket, String message) {
        StringBuilder sb = new StringBuilder();
        if (receiveRequest) {
            sb.append("Receive request").append("\n");
        } else {
            sb.append("Send response").append("\n");
        }
        sb.append("Time: ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())).append("\n");
        sb.append("Client: ").append(socket.getInetAddress().getHostAddress()).append(':').append(socket.getPort()).append("\n");
        sb.append("Server: ").append(socket.getLocalAddress().getHostAddress()).append(':').append(socket.getLocalPort()).append("\n");
        sb.append("Message: ").append(message).append("\n");
        System.out.println(sb.toString());
    }
    
    /**
     * Builds connection with clients.
     * @param args arguments
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7077);
            while (true) {
                Socket socket = serverSocket.accept();
                Server clientHandler = new Server(socket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * A shell which receives requests and sends user-specified responses.
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = clientSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String request;
            while ((request = bufferedReader.readLine()) != null) {
                printLog(true, clientSocket, request);
                
                System.out.print("Please Enter your response: ");
                String response = scanner.next();
                printLog(false, clientSocket, response);
                bufferedWriter.write(response);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
