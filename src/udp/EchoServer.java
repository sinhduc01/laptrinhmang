package src.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class EchoServer {

    public final static int SERVER_PORT = 7; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận

    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            ds = new DatagramSocket(SERVER_PORT); // Tạo Socket với cổng là 7
            System.out.println("Server started ");
            System.out.println("Waiting for messages from Client ... ");

            while (true) { // Tạo gói tin nhận
                DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
                ds.receive(incoming); // Chờ nhận gói tin gởi đến

                // Lấy dữ liệu khỏi gói tin nhận
                String message = new String(incoming.getData(), 0, incoming.getLength());
                System.out.println("Received from " + incoming.getAddress() + ": " + message);

                StringTokenizer stringTokenizer = new StringTokenizer(message, " ");
                int min = 99999999;
                int max = -99999999;
                while (stringTokenizer.hasMoreTokens()) {
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    if (number > max) {
                        max = number;
                    }
                    if (number < min) {
                        min = number;
                    }
                }
                System.out.println("Max: " + max);
                System.out.println("Min: " + min);

                String toClient = "Max: " + max;
                byte[] data = toClient.getBytes();

                // Tạo gói tin gởi chứa dữ liệu vừa nhận được
                DatagramPacket outsending = new DatagramPacket(data, data.length,
                        incoming.getAddress(), incoming.getPort());
                ds.send(outsending);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}