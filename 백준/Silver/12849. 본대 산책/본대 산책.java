import java.io.*;
import java.util.Arrays;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        long[] prev = new long[8];
        long[] curr = new long[8];

        prev[0] = 1;

        int[][] graph = {
                {1, 2},       // 0 - 정보과학관
                {0, 2, 3},    // 1 - 전산관
                {0, 1, 3, 4}, // 2 - 미래관
                {1, 2, 4, 5}, // 3 - 신양관
                {2, 3, 5, 6}, // 4 - 한경직기념관
                {3, 4, 7},    // 5 - 진리관
                {4, 7},       // 6 - 형남공학관
                {5, 6}        // 7 - 학생회관
        };

        for (int day = 0; day < D; day++) {
            Arrays.fill(curr, 0);


            for (int i = 0; i < 8; i++) {
                for (int next : graph[i]) {
                    curr[next] = (curr[next] + prev[i]) % MOD;
                }
            }

            System.arraycopy(curr, 0, prev, 0, 8);
        }

        System.out.println(prev[0]);
    }
}
