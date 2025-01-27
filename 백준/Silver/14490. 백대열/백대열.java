import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] parts = input.split(":");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int gcd = gcd(n, m);
        System.out.println((n / gcd) + ":" + (m / gcd));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
