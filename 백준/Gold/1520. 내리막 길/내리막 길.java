import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int r, int c) {
        if(r==N-1 && c == M-1) {
            return 1; // 경로 경우의 수 누적
        }

        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0; // 방문하지 않은 곳과 구분

        for(int i=0; i<4; i++) {
            int tempR = dr[i] + r;
            int tempC = dc[i] + c;

            if(inRange(tempR, tempC) && map[tempR][tempC] < map[r][c]) {
                dp[r][c] += dfs(tempR, tempC);
            }
        }

        return dp[r][c];
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}