import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NetworkMonitorGUI {
    private JFrame frame;
    private JList<String> computerList;
    private DefaultListModel<String> listModel;
    private JTextArea statusArea;
    private JButton refreshButton;

    public NetworkMonitorGUI() {
        frame = new JFrame("Network Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        computerList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(computerList);
        frame.add(listScrollPane, BorderLayout.CENTER);

        statusArea = new JTextArea();
        statusArea.setEditable(false);
        frame.add(new JScrollPane(statusArea), BorderLayout.SOUTH);

        refreshButton = new JButton("Refresh Status");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshStatus();
            }
        });
        frame.add(refreshButton, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private void refreshStatus() {
        // This method should communicate with the client program to get the status of each machine.
        // For now, we will simulate this with dummy data.
        listModel.clear();
        List<String> computers = NetworkUtils.discoverMachines(); // Assume this method exists
        for (String computer : computers) {
            listModel.addElement(computer);
        }
        statusArea.setText("Status refreshed. Total machines: " + computers.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NetworkMonitorGUI());
    }
}