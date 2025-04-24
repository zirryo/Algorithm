import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();

        int remainder = A % B;

        for (int i = 1; i <= N; i++) {
            remainder *= 10;
            int digit = remainder / B;
            remainder %= B;

            if (i == N) {
                System.out.println(digit);
            }
        }
    }
}
