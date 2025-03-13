import java.io.DataInputStream;
import java.net.*;

public class EXP8Server_A extends Exception {

    public static void main(String[] args) {
        try {
            ServerSocket SS = new ServerSocket(6666);
            Socket S = SS.accept();
            DataInputStream dis = new DataInputStream(S.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);
            SS.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
