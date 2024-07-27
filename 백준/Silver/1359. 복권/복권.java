import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        scanner.close();

        double totalWays = combination(N, M);
        double winningWays = 0;

        for (int i = K; i <= M; i++) {
            if (N - M >= M - i) {
                winningWays += combination(M, i) * combination(N - M, M - i);
            }
        }

        double probability = winningWays / totalWays;
        System.out.printf("%.9f\n", probability);
    }

    public static double combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1.0;
        }

        r = Math.min(r, n - r); // nCr = nC(n-r)
        double result = 1.0;

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }
}