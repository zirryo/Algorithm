import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(st.nextToken());

            long result = getSumOfMultiples(N, 3)
                    + getSumOfMultiples(N, 7)
                    - getSumOfMultiples(N, 21);

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    /* N 이하의 k의 배수들의 총합
     - S(k) = k + 2k + 3k + ... + mk = k * m(m+1) / 2
     - k * (m * (m + 1) / 2)  (m = N / k)
     */
    private static long getSumOfMultiples(long n, int k) {
        long m = n / k;
        return k * (m * (m + 1) / 2);
    }
}