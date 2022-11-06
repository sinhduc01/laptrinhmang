package src;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    public final static String SERVER_IP = "192.168.1.16";
    public final static int SERVER_PORT = 7;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected:" + socket);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            String input;
            // BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // PrintWriter out = new PrintWriter(new
            // BufferedWriter(newOutputStreamWriter(os)));
            input = br.readLine();
            os.writeUTF("Duc");
            while (!input.equalsIgnoreCase("quit"))
                ;
            os.flush();
            os.close();
            is.close();
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
