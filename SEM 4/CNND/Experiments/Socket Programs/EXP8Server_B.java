import java.net.*;
import java.io.*;

class EXP8Server_B {
    public static void main(String args[]) throws Exception {
        ServerSocket SS = new ServerSocket(6666);
        Socket s = SS.accept();
        DataInputStream DIN = new DataInputStream(s.getInputStream());
        DataOutputStream DOS = new DataOutputStream(s.getOutputStream());
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = DIN.readUTF();
            System.out.println("Client: " + str);
            str2 = BR.readLine();
            DOS.writeUTF(str2);
            DOS.flush();
        }
        DIN.close();
        s.close();
        SS.close();
    }
}