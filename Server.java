import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int receivePort = 9000;
        Socket socket = null;
        ServerSocket serverSocket = null;
        PrintWriter pw = null;

        try {
            System.out.println("TCP server starting...: IP address "
                    + InetAddress.getLocalHost().toString() + " port " + receivePort);

            serverSocket = new ServerSocket(receivePort);

            // Wait for a client to connect.
            socket = serverSocket.accept();
            System.out.println("Client connection detected from IP address " + socket.getInetAddress()
                    + " port " + socket.getPort());

            // Open writer to the client and send an initial message
            pw = new PrintWriter(socket.getOutputStream(), true);  // Auto-flush enabled
            pw.println("Hello " + socket.getInetAddress() + " on port " + socket.getPort());

            // Loop sending messages to the client
            while (true) {
                try {
                    // Read input from the server console
                    String line = in.readLine();
                    if (line == null || line.equalsIgnoreCase("exit")) {
                        System.out.println("Closing connection...");
                        break;
                    }

                    // Send the input to the client
                    pw.println(line);

                    // Optional: Display the message sent to the client
                    System.out.println("Sent to client: " + line);

                } catch (Exception se) {
                    System.err.println("Error during communication, closing connection...");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e);
        } finally {
            try {
                if (pw != null) pw.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e);
            }
        }
    }
}
