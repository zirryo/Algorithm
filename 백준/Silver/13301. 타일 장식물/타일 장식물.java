import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] fib = new long[n + 2];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        long perimeter = 2 * (fib[n] + fib[n + 1]);
        System.out.println(perimeter);
    }
}
