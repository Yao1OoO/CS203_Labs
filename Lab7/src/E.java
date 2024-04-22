public class E {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[m];
        int[] kth = new int[m - k + 1];
        AVLTree avl = new AVLTree();
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < m - k + 1; i++) {
            kth[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            avl.insert(arr[i]);
        }
        for (int i = 0; i < m - k + 1; i++) {
            out.println(avl.findKth(kth[i]).data);
            if (i == m - k) break;
            avl.insert(arr[i + k]);
            avl.delete(arr[i]);
        }
        out.close();
    }
}


