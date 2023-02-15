import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Set<Integer> smallStones;
    static final int INF = 10001;
    static int maxVelocity;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        int result = solve();
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxVelocity = (int) Math.sqrt(2*N); // 등차수열을 통해 구한 최대 속력
        smallStones = new HashSet<>();

        dp = new int[N+1][maxVelocity+2];

        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], INF);

        for(int i=0; i<M; i++) {
            int small = Integer.parseInt(br.readLine());
            smallStones.add(small);
        }
    }
    private static int solve() {
        dp[1][0] = 0;

        for(int i=2; i<=N; i++) { // 위치
            if(smallStones.contains(i)) continue;
            for(int j=1; j<=(int) Math.sqrt(2*i); j++) { // 최대 속도
                dp[i][j] = Math.min(Math.min(dp[i-j][j-1], dp[i-j][j]), dp[i-j][j+1]) + 1;
            }
        }

        int result = INF;
        for(int j=1; j<=maxVelocity; j++) {
            result = Math.min(dp[N][j], result);
        }

        if(result == INF) result = -1;
        return result;
    }
}