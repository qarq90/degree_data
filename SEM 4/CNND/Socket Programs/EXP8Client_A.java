import java.io.DataOutputStream;
import java.net.*;

public class EXP8Client_A extends Exception {
    public static void main(String[] args) {
        try {
            Socket S = new Socket("localhost", 6666);
            DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
            DOS.writeUTF("Hello Server");
            DOS.flush();
            DOS.close();
            S.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
