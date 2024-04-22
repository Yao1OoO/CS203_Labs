public class C {
    public static int heapSize = 0;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out= new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        long[] arr1 = new long[n];
        long[] arr2 = new long[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }
        process(arr1,0,n-1);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
        product[] heap = new product[n + m + 10];
        for (int i = 0; i < arr2.length; i++) {
            heap[i + 1] = new product(0, i, arr1[0] * arr2[i]);
            heapSize++;
        }
        for (int i = heapSize / 2; i > 0; i--) {
            int t = i;
            int lSon = t * 2;
            while (lSon <= heapSize) {
                if (lSon == heapSize) {
                    if (heap[lSon].data < heap[t].data) {
                        product temp = heap[lSon];
                        heap[lSon] = heap[t];
                        heap[t] = temp;
                        t = lSon;
                        lSon = 2 * t;
                    } else {
                        break;
                    }
                } else {
                    if ((heap[lSon].data < heap[t].data && heap[lSon + 1].data < heap[t].data
                            && heap[lSon].data <= heap[lSon + 1].data)
                            || (heap[lSon].data < heap[t].data && heap[lSon + 1].data >= heap[t].data)) {
                        product temp = heap[lSon];
                        heap[lSon] = heap[t];
                        heap[t] = temp;
                        t = lSon;
                        lSon = 2 * t;
                    } else if ((heap[lSon].data < heap[t].data && heap[lSon + 1].data < heap[t].data
                            && heap[lSon].data > heap[lSon + 1].data)
                            || (heap[lSon].data >= heap[t].data && heap[lSon + 1].data < heap[t].data)) {
                        product temp = heap[lSon + 1];
                        heap[lSon + 1] = heap[t];
                        heap[t] = temp;
                        t = lSon + 1;
                        lSon = 2 * t;
                    } else {
                        break;
                    }
                }
            }

        }
        //test
//        int i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        delete(heap);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        insert(heap,new product(2));
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        delete(heap);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        insert(heap,new product(4));
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        delete(heap);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        insert(heap,new product(3));
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();

//        delete(heap);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        product test1 = new product(11);
//        product test2 = new product(2);
//        product test3 = new product(1);
//        insert(heap,test1);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        insert(heap,test2);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        insert(heap ,test3);
//        i = 1;
//        while (heap[i] != null){
//            System.out.print(heap[i++].data+" ");
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));


        int t = 0;
        while (t < k) {
            product top = delete(heap);
            t++;
            out.print(top.data + " ");
//            System.out.println("top's a,b : "+ top.aIndex+" " +top.bIndex);
//            System.out.println("top's a+1,b data : "+ arr1[top.aIndex + 1] + "  " +arr2[top.bIndex]);
            if (top.aIndex + 1 < n) {
                product newPro = new product(top.aIndex + 1, top.bIndex,
                        arr1[top.aIndex + 1] * arr2[top.bIndex]);
//                System.out.println("data: "+newPro.data);
                insert(heap, newPro);
            }
        }
        out.close();
    }

    public static product delete(product[] heap) {
        product top = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize] = null;
        heapSize -- ;
        int t = 1;
        int lSon = t * 2;
        while (lSon <= heapSize) {
            if (lSon == heapSize) {
                if (heap[lSon].data < heap[t].data) {
                    product temp = heap[lSon];
                    heap[lSon] = heap[t];
                    heap[t] = temp;
                    t = lSon;
                    lSon = 2 * t;
                } else {
                    break;
                }
            } else {
                if ((heap[lSon].data < heap[t].data && heap[lSon + 1].data < heap[t].data
                        && heap[lSon].data <= heap[lSon + 1].data)
                        || (heap[lSon].data < heap[t].data && heap[lSon + 1].data >= heap[t].data)) {
                    product temp = heap[lSon];
                    heap[lSon] = heap[t];
                    heap[t] = temp;
                    t = lSon;
                    lSon = 2 * t;
                } else if ((heap[lSon].data < heap[t].data && heap[lSon + 1].data < heap[t].data
                        && heap[lSon].data > heap[lSon + 1].data)
                        || (heap[lSon].data >= heap[t].data && heap[lSon + 1].data < heap[t].data)) {
                    product temp = heap[lSon + 1];
                    heap[lSon + 1] = heap[t];
                    heap[t] = temp;
                    t = lSon + 1;
                    lSon = 2 * t;
                } else {
                    break;
                }
            }
        }
        return top;
    }

    public static void insert(product[] heap, product product) {
        heap[heapSize + 1] = product;
        heapSize++;
        int target = heapSize;
        int father = target / 2;
        while (father >= 1) {
            if (heap[target].data < heap[father].data) {
                product temp = heap[target];
                heap[target] = heap[father];
                heap[father] = temp;
                target = father;
                father = target / 2;
            } else {
                break;
            }
        }
    }

    public static void process(long[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(long[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        long[] temp = new long[r - l + 1];
        int k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                //System.out.println("X:" + x);
            }
            k++;
        }

        while (i <= m) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        //System.out.println(Arrays.toString(temp));
        for (int n = 0; n < r - l + 1; n++) {
            arr[n + l] = temp[n];
        }
    }
}

class product {
    int aIndex;
    int bIndex;
    long data;

    public product(long data) {
        this.data = data;
    }

    public product(int a, int b, long data) {
        this.aIndex = a;
        this.bIndex = b;
        this.data = data;
    }
}
