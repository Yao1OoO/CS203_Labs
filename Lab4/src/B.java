public class B {
    public static void main(String[] args) {
        QReader in = new QReader();
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        int[] queue1 = new int[p];
        int[] queue2 = new int[q];
        for (int i = 0; i < queue1.length; i++) {
            queue1[i] = in.nextInt();
        }
        for (int i = 0; i < queue2.length; i++) {
            queue2[i] = in.nextInt();
        }
        int[] result = new int[n];
        boolean[] buy = new boolean[n];
        int i = 0;
        int j = 0;
        int time = 0;
        while (i < p && j < q) {
            time++;
            if (queue1[i] == queue2[j]) {
                result[queue1[i] - 1] = time;
                buy[queue1[i] - 1] = true;
            }
            result[queue1[i] - 1] = time;
            buy[queue1[i] - 1] = true;
            result[queue2[j] - 1] = time;
            buy[queue2[j] - 1] = true;
            while (i < p && buy[queue1[i] - 1]) {
                i++;
            }
            while (j < q && buy[queue2[j] - 1]) {
                j++;
            }
        }
        while (i < p) {
            if (!(buy[queue1[i] - 1])) {
                time++;
                buy[queue1[i] - 1] = true;
                result[queue1[i] - 1] = time;
            }
            i++;
        }

        while (j < q) {
            if (!(buy[queue2[j] - 1])) {
                time++;
                buy[queue2[j] - 1] = true;
                result[queue2[j] - 1] = time;
            }
            j++;
        }
        for (int k = 0; k < result.length - 1; k++) {
            System.out.print(result[k] + " ");
        }
        System.out.println(result[result.length - 1]);
    }
}

