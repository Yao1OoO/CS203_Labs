import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,4,6,3,1,6,8,4,55,2,88,4,22,36};
        System.out.println(Arrays.toString(arr));
        C.process(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
