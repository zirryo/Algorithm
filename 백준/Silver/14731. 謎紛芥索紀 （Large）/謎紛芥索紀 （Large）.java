import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long C = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            
            if (K == 0) continue;
            
            long powerVal = power(2, K - 1);
            long term = (C * K) % MOD;
            term = (term * powerVal) % MOD;

            result = (result + term) % MOD;
        }

        System.out.println(result);
    }
    
    static long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b /= 2;
        }
        return res;
    }
}