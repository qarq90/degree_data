import java.net.*;
import java.io.*;

class EXP8Client_B {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 6666);
        DataInputStream DIN = new DataInputStream(s.getInputStream());
        DataOutputStream DOS = new DataOutputStream(s.getOutputStream());
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = BR.readLine();
            DOS.writeUTF(str);
            DOS.flush();
            str2 = DIN.readUTF();
            System.out.println("Server: " + str2);
        }

        DOS.close();
        s.close();
    }
}