import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> sets = new ArrayList<>(); // {사람, 닭}
        int f1 = 1;
        int f2 = 2;

        while (f2 <= N) {
            sets.add(new int[]{f2, f1});
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }

        int[] minDP = new int[N + 1];
        int[] maxDP = new int[N + 1];
        final int INF = 1_000_000_000;

        Arrays.fill(minDP, INF);
        Arrays.fill(maxDP, -1);

        minDP[0] = 0;
        maxDP[0] = 0;

        for (int[] set : sets) {
            int p = set[0];
            int c = set[1];

            for (int j = p; j <= N; j++) {
                if (minDP[j - p] != INF) {
                    minDP[j] = Math.min(minDP[j], minDP[j - p] + c);
                }

                if (maxDP[j - p] != -1) {
                    maxDP[j] = Math.max(maxDP[j], maxDP[j - p] + c);
                }
            }
        }

        System.out.println(minDP[N] + " " + maxDP[N]);
    }
}