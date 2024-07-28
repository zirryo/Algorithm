import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        int minBallsNeeded = K * (K + 1) / 2;

        if (N < minBallsNeeded) {
            System.out.println(-1);
            return;
        }

        int remainingBalls = N - minBallsNeeded;
        remainingBalls %= K;

        int result = K - 1 + (remainingBalls % K == 0 ? 0 : 1);
        System.out.println(result);
    }
}
