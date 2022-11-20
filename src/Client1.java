package src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public final static String SERVER_IP = "172.20.10.9";
    public final static int SERVER_PORT = 999;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // connect to sever
            System.out.println("Connected :" + socket);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            System.out.print("Client:");
            int n = scanner.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("a[" + (i + 1) + "]: ");
                arr[i] = scanner.nextDouble();
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(arr[i] + " ");
            }
            // System.out.println(stringBuilder);
            os.writeUTF("" + stringBuilder);
            String response = is.readUTF();
            System.out.println("From server:\n" + response);
            os.close();
            is.close();
        } catch (IOException e) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}