import java.util.*;

public class Main {
    static long P, Q, X, Y;
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        X = sc.nextLong();
        Y = sc.nextLong();

        System.out.println(dp(n));
    }

    static long dp(long n) {
        if (n <= 0) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = dp(n / P - X) + dp(n / Q - Y);
        memo.put(n, result);
        return result;
    }
}
