public class B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] heap = new int[n + 1];
        int[] times = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            int t = i;
            heap[i] = in.nextInt();
            int time = 0;
            while (t > 1) {
                if (heap[t] > heap[t / 2]) {
                    time++;
                    times[i] = time;
                    int temp = heap[t];
                    heap[t] = heap[t / 2];
                    heap[t / 2] = temp;
                    t = t / 2;
                }else break;
            }
        }
        for (int i = 1; i < times.length; i++) {
            out.print(times[i] + " ");
        }
        out.close();
    }
}
