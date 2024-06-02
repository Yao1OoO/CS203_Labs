import javax.naming.PartialResultException;
import javax.swing.*;
import java.util.Arrays;

public class E {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        while (in.hasNext()){
            int l = in.nextInt(),n = in.nextInt(),m = in.nextInt();
            int[]arr = new  int[n+1];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            arr[n] =l;
            Arrays.sort(arr);
            int[] length = new int[n+1];
            length[0] = arr[0];
            for (int i = 1; i < n+1; i++) {
                length[i] = arr[i] -arr [i-1];
            }
//            System.out.println(Arrays.toString(length));
//            out.println(minLength(l,length,n,m));
//            out.close();
            System.out.println(minLength(l,length,n,m));
        }
    }
    public static int minLength(int length,int[]arr,int n ,int m){
        int l = length/m,r = length;
        while (l<r){
            int mid = (l+r)/2;
            //System.out.println(l+"   "+r+"   "+"   "+mid);
            if (check(arr,mid,n,m)){
                r = mid;
            }else {
                l = mid +1;
            }
            //System.out.println((l+"   "+r+"   "+"   "+mid));
            if (l == r){
                return l;
            }
        }
        return 0;
    }

    public static boolean check(int[]arr ,int x,int n,int m){
        int count = 0;
        int sum = 0;
        int i = 0;
        while (i < n+2){
            if (i == n +1){
                count++;
                break;
            }
            if (arr[i] > x) {
                return false;
            }
            if (sum+arr[i] <= x ){
                sum +=arr[i];
            }else {
                count++;
                sum =arr[i];
            }
            i++;
        }
        //System.out.println(count);
        if (count <=m){
            return true;
        }
        return false;
    }
}
