package numarray;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Number {
    public static void main(String[] ags) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("D:\\GitHUB\\laptrinhmang\\numarray\\numIn.txt")));
        sort(text);
    }

    public static ArrayList<Long> sort(String text) {
        StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
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
        try {
            FileWriter myWriter = new FileWriter("D:\\GitHUB\\laptrinhmang\\numarray\\numOut.txt");
            myWriter.write("Tong la: " + tong + "\n");
            myWriter.write("Danh sach sap xep:" + arrayList);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Bi loi roi, khong ghi duoc huhu");
            e.printStackTrace();
        }
        return arrayList;
    }
}
