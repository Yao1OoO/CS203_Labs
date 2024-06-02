public class F {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        long x1 = in.nextInt();
        long y1 = in.nextInt();
        long x2 = in.nextInt();
        long y2 = in.nextInt();
        int n = in.nextInt();
        String str = in.next();
        char[] arr = str.toCharArray();
        if (binarySearch(arr, x1, y1, x2, y2) <= (long) 1e14) {
            out.println(binarySearch(arr, x1, y1, x2, y2));
        } else {
            out.println(-1);
        }
        out.close();
    }

    static long binarySearch(char[] arr, long x1, long y1, long x2, long y2) {
        long l = 0, r = (long) 1e14;
        long mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(arr, x1, y1, x2, y2, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static boolean check(char[] arr, long x1, long y1, long x2, long y2, long s) {
        long h1 = 0, w1 = 0, h2 = 0, w2 = 0;
        for (char direction : arr) {
            if (direction == 'U') {
                h1++;
            } else if (direction == 'D') {
                h1--;
            } else if (direction == 'R') {
                w1++;
            } else {
                w1--;
            }
        }
        long loop = s / arr.length;
        long rest = s % arr.length;
        for (int i = 0; i < rest; i++) {
            if (arr[i] == 'U') {
                h2++;
            } else if (arr[i] == 'D') {
                h2--;
            } else if (arr[i] == 'R') {
                w2++;
            } else {
                w2--;
            }
        }
        long h = loop * h1 + h2;
        long w = loop * w1 + w2;
        long distance = Math.abs(x2 + w - x1) + Math.abs(y2 + h - y1);
        if (distance <= s) {
            return true;
        }
        return false;
    }
}
