import java.net.*;
import java.io.*;

public class EXP9Client_A {
    public static void main(String[] args) {
        String serverName = "localhost"; // Server address
        int port = 6066; // Port number

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Connected to " + client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("Server says: " + in.readUTF());

            client.close(); // Close connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
