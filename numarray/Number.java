package numarray;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Number {
    public static void main(String[] ags) throws IOException {
        // String text = "";
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
        System.out.println("Tong la: " + tong);
        System.out.println("Danh sach sap xep:" + arrayList);
        return arrayList;
    }
}
