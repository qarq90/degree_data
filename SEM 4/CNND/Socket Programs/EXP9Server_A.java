import java.net.*;
import java.io.*;

public class EXP9Server_A extends Thread {
    private ServerSocket serverSocket;

    public EXP9Server_A(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept(); // Accept client connection

                System.out.println("Connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("Client says: " + in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close(); // Close connection
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 6066; // Default port
        try {
            Thread t = new EXP9Server_A(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
