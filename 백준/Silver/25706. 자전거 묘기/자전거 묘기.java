import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] h = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            h[i] = sc.nextInt();
        }

        int[] dp = new int[N + 2];

        for (int i = N; i >= 1; i--) {
            int landingPoint = i + h[i] + 1;
            if (landingPoint > N) {
                dp[i] = 1;
            } else {
                dp[i] = dp[landingPoint] + 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
