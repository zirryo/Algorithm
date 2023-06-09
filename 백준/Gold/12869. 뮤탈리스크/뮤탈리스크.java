import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static Integer[] scvOriginal;
    static int[][][] dp;
    static final int MAX = 61;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        scvOriginal = new Integer[3];
        dp = new int[61][61][61];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            if (i >= N) scvOriginal[i] = 0;
            else scvOriginal[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }
        System.out.println(getMinCnt(scvOriginal.clone(), 0));
    }
    private static int getMinCnt(Integer[] scv, int depth) {
        boolean flag = false;
        for (int i=0; i<3; i++) {
            if (scv[i] > 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            Arrays.sort(scv, Collections.reverseOrder());

            if (dp[scv[0]][scv[1]][scv[2]] != MAX) return dp[scv[0]][scv[1]][scv[2]];

            for (int i = 0; i < 6; i++) {
                Integer[] temp = new Integer[3];
                temp[0] = Math.max(scv[0] - attack[i][0], 0);
                temp[1] = Math.max(scv[1] - attack[i][1], 0);
                temp[2] = Math.max(scv[2] - attack[i][2], 0);

                dp[scv[0]][scv[1]][scv[2]] = Math.min(dp[scv[0]][scv[1]][scv[2]], getMinCnt(temp, depth+1));
            }
        } else return depth;
        return dp[scv[0]][scv[1]][scv[2]];
    }
}