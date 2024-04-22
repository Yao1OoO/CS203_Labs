import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        int dataSize = 15;
        for (int i = 0; i < dataSize; i++) {
            int num = r.nextInt(30);
            set.add(num);
            System.out.println("avl.insert("+num+");");
        }
        int delOp = 5;
        for (int i = 0; i < delOp; i++) {
            int x = r.nextInt(set.size()) + 1;
            int cnt = 0;
            int delNum = 0;
            for (int num : set) {
                if (cnt++ == x) {
                    delNum = num;
                    break;
                }
            }
            System.out.println("avl.delete("+delNum+");");
            set.remove(delNum);
        }
    }
}
