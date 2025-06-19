import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Math.abs(Long.parseLong(br.readLine()));

        if (K == 0) {
            System.out.println(0);
            return;
        }

        int maxBits = 60; 
        for (int n = 1; n <= maxBits; n++) {
            long sum = (1L << n) - 1; // 2^n - 1
            if (sum >= K && (sum - K) % 2 == 0) {
                System.out.println(n);
                return;
            }
        }

        System.out.println(-1);
    }
}
