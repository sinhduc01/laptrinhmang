package src.numsum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class numSum {
    public final static int SERVER_PORT = 6868;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
                    DataInputStream is = new DataInputStream(socket.getInputStream());
                    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                    String message = is.readUTF();
                    System.out.println("Client: " + message);
                    os.writeUTF("Cac so la:" + sumNumber(message));
                    os.flush();
                    is.close();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> sumNumber(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            int value = Integer.parseInt(token);
            arrayList.add(value);
        }
        for (int i = Integer.parseInt(String.valueOf(arrayList.get(0))); i < Integer
                .parseInt(String.valueOf(arrayList.get(1))); i++) {
            if (sum(i) == 15) {
                sumList.add(i);
            }
        }
        return sumList;
    }

    public static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
