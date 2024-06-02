import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int l = input.nextInt(), w = input.nextInt(), h = input.nextInt();
            String cub[][] = new String[(h + w) * 2 + 1][(l + w) * 2 + 1];
            for (int j = 0; j < 2 * h + 1; j++) {
                if (j % 2 == 0) {
                    for (int k = 0; k < 2 * l + 1; k++) {
                        if (k % 2 == 0) {
                            cub[(h + w) * 2 - j][k] = "+";
                        } else {
                            cub[(h + w) * 2 - j][k] = "-";
                        }
                    }
                } else {
                    for (int k = 0; k < 2 * l + 1; k++) {
                        if (k % 2 == 0) {
                            cub[(h + w) * 2 - j][k] = "|";
                        } else {
                            cub[(h + w) * 2 - j][k] = ".";
                        }
                    }
                }
            }
            for (int j = 0; j < w * 2; j++) {
                if (j % 2 == 0) {
                    for (int k = 0; k < 2*l+1; k++) {
                        if (k%2 == 0){
                            cub[j][2*w-j+k] = "+";
                        }else {
                            cub[j][2*w-j+k] = "-";
                        }
                    }
                    for (int k = 0; k < 2*h; k++) {
                        if (k%2 == 0){
                            cub[1+j+k][(l + w) * 2-j] = "|";
                        }else {
                            cub[1+j+k][(l + w) * 2-j] = "+";
                        }
                    }
                }else{
                    for (int k = 0; k < 2*l+1; k++) {
                        if (k%2 == 0){
                            cub[j][2*w-j+k] = "/";
                        }else {
                            cub[j][2*w-j+k] = ".";
                        }
                    }
                    for (int k = 0; k < 2*h; k++) {
                        if (k%2 == 0){
                            cub[1+j+k][(l + w) * 2-j] = ".";
                        }else {
                            cub[1+j+k][(l + w) * 2-j] = "/";
                        }
                    }
                }
            }
            for (int j = 0; j < 2*w; j++) {
                for (int k = 0; k < 2*w-j; k++) {
                    cub[j][k] =".";
                }
            }
            for (int j = 0; j < 2*w; j++) {
                for (int k = 0; k < 2*w-j; k++) {
                    cub[(h + w) * 2 -j][(l + w) * 2 -k] =".";
                }
            }
            //test
            for (int j = 0; j < (h + w) * 2 + 1; j++) {
                for (int k = 0; k < (l + w) * 2 + 1; k++) {
                    System.out.print(cub[j][k]);
                }
                System.out.println();
            }
        }
    }
}
