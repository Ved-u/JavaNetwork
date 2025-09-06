import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class NetworkUtils {

    public static List<InetAddress> discoverMachines(int timeout) {
        List<InetAddress> machines = new ArrayList<>();
        try {
            for (int i = 1; i < 255; i++) {
                String host = "192.168.1." + i; // Adjust the subnet as necessary
                InetAddress address = InetAddress.getByName(host);
                if (address.isReachable(timeout)) {
                    machines.add(address);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return machines;
    }

    public static String sendMessage(InetAddress address, int port, String message) {
        try (Socket socket = new Socket(address, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
             
            out.println(message);
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkMachineStatus(InetAddress address, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(address, port), 2000);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}