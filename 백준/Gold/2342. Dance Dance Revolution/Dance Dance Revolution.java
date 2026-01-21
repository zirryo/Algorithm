import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;
    static List<Integer> moves;
    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        moves = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int move = Integer.parseInt(st.nextToken());
            if (move == 0) break;
            moves.add(move);
        }

        int size = moves.size();
        if (size == 0) {
            System.out.println(0);
            return;
        }

        // dp[n][l][r] : n번째 발판에서 왼발 l, 오른발 right일 때 최소 힘
        dp = new int[size + 1][5][5];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < size; i++) {
            int next = moves.get(i);
            for (int L = 0; L < 5; L++) {
                for (int R = 0; R < 5; R++) {
                    int currentPower = dp[i][L][R];
                    if (currentPower == INF) continue;

                    if (next != R) {
                        dp[i + 1][next][R] = Math.min(dp[i + 1][next][R], currentPower + getCost(L, next));
                    }

                    if (next != L) {
                        dp[i + 1][L][next] = Math.min(dp[i + 1][L][next], currentPower + getCost(R, next));
                    }
                }
            }
        }

        int minPower = INF;
        for (int L = 0; L < 5; L++) {
            for (int R = 0; R < 5; R++) {
                minPower = Math.min(minPower, dp[size][L][R]);
            }
        }
        System.out.println(minPower);
    }

    static int getCost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}