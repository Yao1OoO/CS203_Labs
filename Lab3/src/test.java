import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] arr1 = new int[50];
        for (int i = 0; i < 50; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < 50; i++) {
            int max = -1;
            int k = 0;
            for (int j =0 ; j < 50; j++) {
                if (arr1[j] > max){
                    k = j;
                    max = arr1[j];
                }
            }
            arr1[k] = 50 - i;
        }
        for (int i = 0; i < 50; i++) {
            System.out.print(arr1[i] +" ");
        }
    }
}