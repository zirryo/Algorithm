import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0); // 시작위치와 방향 지정
        System.out.println(result);
    }

    // dir = 0 가로, dir = 1 세로, dir = 2 대각선
    private static void dfs(int r, int c, int dir) {
        if(r==N-1 && c==N-1) {
            result++;
            return;
        }

        if(dir == 0) {
            if(c+1 < N && map[r][c+1] == 0) { // 우측으로 이동
                dfs(r, c+1, 0);
            }
        } else if (dir == 1) {
            if(r+1 < N && map[r+1][c] == 0) { // 아래로 이동
                dfs(r+1, c, 1);
            }
        } else {
            if(c+1 < N && map[r][c+1] == 0) { // 우측으로 이동
                dfs(r, c+1, 0);
            }

            if(r+1 < N && map[r+1][c] == 0) { // 아래로 이동
                dfs(r+1, c, 1);
            }
        }

        // 기존 방향과 상관없이 대각선 이동 가능
        if(r+1 < N && c+1 < N && map[r+1][c+1] == 0 && map[r][c+1] == 0 && map[r+1][c] == 0) {
            dfs(r+1, c+1, 2);
        }
    }

}