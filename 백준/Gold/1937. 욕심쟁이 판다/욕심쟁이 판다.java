import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static int[][] board;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        init();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }
        System.out.println(result);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    private static int dfs(int x, int y) {
        if(dp[x][y] != 0) return dp[x][y]; // 이미 값을 알고 있다면 리턴
        dp[x][y] = 1; // 어느 위치라도 하루는 생존할 수 있음
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
            if(board[nx][ny] > board[x][y]) dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }
        return dp[x][y];
    }
}