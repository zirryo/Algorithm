import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result = 0;
    static int[][] map;
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=1; j<M-1; j++) {
                if(s.charAt(j) == 'x') map[i][j] = -1;
            }
        }

        for(int r = 0; r < N; r++) {
            if(dfs(r, 0)) result++;
        }
        System.out.println(result);
    }
    private static boolean dfs(int r, int c) {
        map[r][c] = 1;
        if(c == M-1) {
            return true;
        }
        for(int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr >= N || nc >= M) continue;
            if(map[nr][nc] == 0 && dfs(nr, nc)) return true;
        }
        return false;
    }
}