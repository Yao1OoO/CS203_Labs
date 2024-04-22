public class F {
    public static void main(String[] args) {
        QReader in = new QReader();
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        long[][] plant = new long[n][5];
        long pow = 1;
        for (int i = 0; i < p; i++) {
            pow *= 2;
        }
        for (int i = 0; i < n; i++) {
            plant[i][0] = in.nextLong();
            plant[i][1] = in.nextLong();
            plant[i][2] = plant[i][0] - plant[i][1];
            plant[i][3] = plant[i][0] * pow - plant[i][1];
            plant[i][4] = plant[i][0] * (pow - 1);
            //System.out.println(Math.pow(2,p));
        }
        long sum = 0;
        if(q == 0){
            for (int i = 0; i < plant.length; i++) {
                sum +=plant[i][1];
            }
            System.out.println(sum);
            return;
        }
        sort(plant, 0, plant.length - 1);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(plant[i]));
//        }
        long max = 0;

        int k = 0;
        int j = 0;

        for (int i = 0; i < plant.length; i++) {
            if (j < q && plant[i][2] > 0) {
                plant[i][1] = plant[i][0];
                j++;
            }
            sum += plant[i][1];
        }
//        System.out.println(sum);
        for (int i = 0; i < plant.length; i++) {
            if (q > j) {
                if (i < j) {
                    if (plant[i][4] > max) {
                        max = plant[i][4];
                        k = i;
//                        System.out.println(111);
                    }
                } else {
                    if (plant[i][3] > max) {
                        max = plant[i][3];
                        k = i;
//                        System.out.println(222);
                    }
                }
            } else {
                if (i < j) {
                    if (plant[i][4] > max) {
                        max = plant[i][4];
                        k = i;
//                        System.out.println(333);
                    }
                } else if (j == 0){
                    max =Math.max(max,plant[i][3]);
                }else {
                    if (plant[i][3] - plant[j - 1][2] > max) {
                        max = plant[i][3] - plant[j - 1][2];
//                        System.out.println(j);
//                        System.out.println(plant[j-1][2]);
//                        System.out.println(max);
                        k = i;
//                        System.out.println(444);
                    }
                }
            }
        }
        sum += max;


////        System.out.println(sum);
////        System.out.println(j);
////        System.out.println(k);
//        if (plant[k][2] <= 0) {
//            if (j < q) {
//                sum += plant[k][3];
////                System.out.println("111");
//            } else {
//                sum += plant[k][3];
//                sum -= plant[q-1][2];
////                System.out.println("222");
//            }
//        } else {
//            if (k < q) {
//                sum += plant[k][3] - plant[k][2] + plant[k][0];
//                sum -= plant[k][1];
////                System.out.println("333");
//            } else {
////                System.out.println(sum);
//                sum += plant[k][3];
////                System.out.println(sum);
//                sum -= plant[q-1][2];
////                System.out.println(plant[q-1][2]);
////                System.out.println("444");
//            }
//        }
        System.out.println(sum);
    }

    public static void sort(long[][] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(long[][] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        long[][] temp = new long[r - l + 1][5];
        int k = 0;
        while (i <= m && j <= r) {
            if (arr[i][2] >= arr[j][2]) {
                temp[k][0] = arr[i][0];
                temp[k][1] = arr[i][1];
                temp[k][2] = arr[i][2];
                temp[k][3] = arr[i][3];
                temp[k][4] = arr[i][4];
                i++;
            } else {
                temp[k][0] = arr[j][0];
                temp[k][1] = arr[j][1];
                temp[k][2] = arr[j][2];
                temp[k][3] = arr[j][3];
                temp[k][4] = arr[j][4];
                j++;
            }
            k++;
        }
        while (i <= m) {
            temp[k][0] = arr[i][0];
            temp[k][1] = arr[i][1];
            temp[k][2] = arr[i][2];
            temp[k][3] = arr[i][3];
            temp[k][4] = arr[i][4];
            i++;
            k++;
        }
        while (j <= r) {
            temp[k][0] = arr[j][0];
            temp[k][1] = arr[j][1];
            temp[k][2] = arr[j][2];
            temp[k][3] = arr[j][3];
            temp[k][4] = arr[j][4];
            j++;
            k++;
        }
//        for (int n = 0; n < temp.length; n++) {
//            System.out.println(Arrays.toString(temp[n]));
//        }

        for (int n = 0; n < r - l + 1; n++) {
            arr[n + l][0] = temp[n][0];
            arr[n + l][1] = temp[n][1];
            arr[n + l][2] = temp[n][2];
            arr[n + l][3] = temp[n][3];
            arr[n + l][4] = temp[n][4];
        }
    }
}
