import java.io.*;
import java.net.*;

public class NetworkClient {
    private static final int SERVER_PORT = 9000;
    private static final String SERVER_ADDRESS = "localhost"; // Change to server IP if needed

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send initial status to the server
            out.println("Client connected from " + InetAddress.getLocalHost());

            // Periodically report status
            while (true) {
                // Simulate status reporting
                String status = "Status report from client at " + InetAddress.getLocalHost();
                out.println(status);
                System.out.println("Sent to server: " + status);

                // Wait for a response from the server
                String response = in.readLine();
                if (response != null) {
                    System.out.println("Received from server: " + response);
                }

                // Sleep for a while before the next report
                Thread.sleep(5000); // Report every 5 seconds
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}