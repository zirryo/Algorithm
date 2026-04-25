import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();

        long[][] pascal = new long[31][31];
        pascal[1][1] = 1;

        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        long sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                sum += pascal[R + i][C + j];
            }
        }

        System.out.println(sum);
    }
}