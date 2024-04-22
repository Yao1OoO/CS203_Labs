import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int arr[] = new int[t];
            int max, diff;
            for (int j = 0; j < t; j++) {
                arr[j] = in.nextInt();
            }
            max = arr[0];
            diff = arr[0] - arr[1];
            for (int j = 2; j < t; j++) {
                if (arr[j - 1] > max) {
                    max = arr[j - 1];
                }
                if (max - arr[j] > diff) {
                    diff = max - arr[j];
                }
            }
            System.out.println(diff);
        }
    }
}


