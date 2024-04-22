import java.io.*;
import java.util.Random;
class QWriterFrandom implements Closeable {
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
public class QFrandom {
    public static void main(String[] args) {
        Random random = new Random();
        QWriterFrandom writer = new QWriterFrandom();
        int T = 1;
        writer.println(T);
        for (int i = 0; i < T; i++) {
            int n = 10000;
            writer.println(n);
            for (int j = 0; j < n; j++) {
                int number = random.nextInt(100000) + 1;
                writer.print(number + " ");
            }
            writer.println("");
        }
        writer.close();
    }
}
