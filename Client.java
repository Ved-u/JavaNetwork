import java.io.*;
import java.net.*;
import java.util.Scanner;

class IPgenerator2 {
    String view_host;

    // Prints IPs and allows the user to choose one
    String ipmethd() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 6; i++) {  // Updated to print correct range of IPs
            System.out.print(i + ". ");
            System.out.println("148.197.67.21" + i);
        }

        System.out.print("SELECT A MACHINE TO VIEW FROM LIST: ");
        int choice = scanner.nextInt();  // Use Scanner to read integer input
        scanner.close();

        switch (choice) {
            case 1: view_host = "148.197.67.211"; break;
            case 2: view_host = "148.197.67.212"; break;
            case 3: view_host = "148.197.67.213"; break;
            case 4: view_host = "148.197.67.214"; break;
            case 5: view_host = "148.197.67.215"; break;
            case 6: view_host = "148.197.67.216"; break;
            default: 
                System.out.println("This machine doesn't exist, please choose a valid host");
                return null;
        }
        return view_host;
    }
}

public class Client {
    public static void main(String args[]) {
        IPgenerator2 ip = new IPgenerator2();
        String remoteIPaddress = ip.ipmethd();
        if (remoteIPaddress == null) {
            return;  // Exit if invalid host selection
        }
        
        int remotePort = 9000;

        try {
            Socket socket1 = new Socket(remoteIPaddress, remotePort);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            System.out.println("Server contacted OK");

            // loop reading messages from server
            String line;
            while ((line = inFromServer.readLine()) != null) {
                System.out.println("From server: " + line);
            }

            // Close the socket after the communication is done
            socket1.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ....");
        } catch (ConnectException e) {
            System.err.println("Unreachable node!, failure in connecting to server");
        } catch (IOException e) {
            System.err.println("TCP client error " + e);
        }
    }
}
