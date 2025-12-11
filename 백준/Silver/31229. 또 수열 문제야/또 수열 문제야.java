import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int LIMIT = 100000;
        boolean[] isComposite = new boolean[LIMIT + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= LIMIT; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                if ((long)i * i <= LIMIT) {
                    for (int j = i * i; j <= LIMIT; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
            if (primes.size() >= N) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(primes.get(i));
        }
        System.out.println(sb.toString());
    }
}
