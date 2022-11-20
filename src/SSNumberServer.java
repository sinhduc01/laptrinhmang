package src;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SSNumberServer {
    public final static int SERVER_PORT = 100;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
                    DataInputStream is = new DataInputStream(socket.getInputStream());
                    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                    String messageFromClient;
                    while (true) {
                        messageFromClient = is.readUTF();
                        // StringBuilder input1 = new StringBuilder();
                        // input1.append(messageFromClient);
                        if (messageFromClient.equalsIgnoreCase("quit")) {
                            os.writeUTF("Quit!");
                            break;
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(messageFromClient, " ");
                        int i = 1;
                        long tong = 0;
                        ArrayList<Long> arrayList = new ArrayList<Long>();
                        while (stringTokenizer.hasMoreTokens()) {
                            String token = stringTokenizer.nextToken();
                            long value = Long.parseLong(token);
                            arrayList.add(value);
                            tong += value;
                            i++;
                        }
                        Collections.sort(arrayList);
                        os.writeUTF("Tong la: " + tong + "\n" + "Danh sach da sap xep: "
                                + arrayList.toString().replace("[", "").replace("]", ""));
                        os.flush();
                    }
                    ;
                    os.close();
                    is.close();
                    socket.close();
                } catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
