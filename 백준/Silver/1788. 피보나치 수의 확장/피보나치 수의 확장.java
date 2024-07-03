import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int MOD = 1_000_000_000;

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int[] fib = new int[Math.abs(n) + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= Math.abs(n); i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % MOD;
        }

        int result = fib[Math.abs(n)];

        if (n < 0 && (n % 2) == 0) {
            result *= -1;
        }

        if (result > 0) {
            System.out.println(1);
        } else if (result < 0) {
            System.out.println(-1);
            result = Math.abs(result);
        } else {
            System.out.println(0);
        }

        System.out.println(result);
    }
}