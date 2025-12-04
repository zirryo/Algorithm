import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                C[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long best = Long.MIN_VALUE;
        int limit = 1 << N;
        for (int mask = 0; mask < limit; mask++) {
            if (Integer.bitCount(mask) != K) continue;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) == 0) continue;
                for (int j = i + 1; j < N; j++) {
                    if ((mask & (1 << j)) != 0) {
                        sum += C[i][j];
                    }
                }
            }
            if (sum > best) best = sum;
        }

        System.out.println(best);
    }
}
