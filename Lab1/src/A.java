import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.*;
import java.util.*;

public class A {
    static  boolean flag;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //System.out.println(Arrays.toString(arr));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            flag = false;
            if (binarySearch(arr,x ,0 ,n -1)){
                out.println("YES");
            }else out.println("NO");
        }
        out.close();
    }

    static boolean binarySearch(int[] arr, int x, int l, int r) {

        if (l > r) return false;
        int mid = (l + r) / 2;
        //System.out.println(l+"  "+r+ "  "+ mid);
        //System.out.println(arr[mid] +"   "+ x);
        if (arr[mid] == x) {
            flag = true;
            return true;
        }

        if (arr[mid] > x) {
            binarySearch(arr, x, l, mid - 1);
        } else if (arr[mid] < x) {
            binarySearch(arr, x, mid + 1, r);
        }

        if (flag) return true;
        return false;
    }
}


class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
