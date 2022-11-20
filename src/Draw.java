package src;

import java.io.*;
import java.util.Scanner;

class GFG {

    // Function to print hollow rectangle
    static void print_rectangle(int n, int m) {
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (i == 1 || i == n ||
                        j == 1 || j == m)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }

    static void print_square(int n) {
        int i, j;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (i == 1 || i == n ||
                        j == 1 || j == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }

    static void print_circle(double distance) {
        int rad;
        // Accept data from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any value for radius: ");
        rad = sc.nextInt();
        System.out.println("Circle Pattern:\n");
        // Use for loop for row wise
        for (int row = 0; row <= 2 * rad; row++) {
            // Use for loop for col wise
            for (int col = 0; col <= 2 * rad; col++) {
                distance = Math.sqrt((row - rad) * (row - rad) + (col - rad) * (col - rad));

                /**
                 * Check whether distance is in the range of (radius - 0.5) and (radius + 0.5)
                 * or not to print *
                 */
                if (distance > rad - 0.5 && distance < rad + 0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Driver program for above function
    public static void main(String args[]) {
        int rows = 6, columns = 20;
        print_rectangle(rows, columns);
        print_square(rows);
    }
}
