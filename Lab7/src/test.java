import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(10);
        tree.insert(15);
        tree.insert(3);
        tree.insert(9);
        tree.insert(14);
        tree.insert(1);
        tree.delete(7);
        tree.delete(8);
        tree.print();
    }
}
