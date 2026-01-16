import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] move = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    move[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            long[] target = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                target[i] = Long.parseLong(st.nextToken());
            }

            long result = solve(n, move, target);

            if (result == 0) sb.append("0\n");
            else sb.append("1 ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static long solve(int n, int[][] move, long[] target) {
        long[] c = new long[n];
        long totalMoves = 0;

        for (int i = 0; i < n; i++) {
            long currentVal = 0;
            for (int k = 0; k < i; k++) {
                currentVal += c[k] * move[k][i];
            }

            c[i] = target[i] - currentVal;

            if (c[i] < 0) {
                return 0L;
            }

            totalMoves += c[i];

            if (totalMoves > 2000000000L) {
                return 0L;
            }
        }

        return totalMoves;
    }
}