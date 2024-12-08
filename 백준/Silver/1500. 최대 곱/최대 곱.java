import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int base = S / K;
        int remainder = S % K;

        long result = 1;

        for (int i = 0; i < K; i++) {
            if (i < remainder) {
                result *= (base + 1);
            } else {
                result *= base;
            }
        }

        System.out.println(result);
    }
}
