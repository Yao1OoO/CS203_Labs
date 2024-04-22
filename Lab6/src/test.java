public class test {
    public static void main(String[] args) {
        int a =  4, b =3;
        a = a >= b ? a+1 : b;
        System.out.println(a);

    }
    public void dfs(){
        //xxxxxxx
        dfs();
        //yyyyyyy
    }
}