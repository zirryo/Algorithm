import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[120];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 118; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 118; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 118; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            boolean flag = false;
            for (int p1 : primes) {
                if (p1 >= a) break; // p1이 이미 a보다 크면 탐색 종료
                int p2 = a - p1;
                if (isPrime[p2]) {
                    flag = true;
                    break;
                }
            }

            sb.append(flag ? "Yes" : "No").append("\n");
        }

        System.out.print(sb);
    }
}