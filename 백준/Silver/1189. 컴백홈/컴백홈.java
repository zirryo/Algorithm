import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        isVisited[N-1][0] = true;

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                if(s.charAt(j)=='T') {
                    map[i][j] = 1; // 갈 수 없는 곳 표시
                    isVisited[i][j] = true;
                }
            }
        }
        dfs(N-1, 0, 1);
        System.out.println(cnt);

    }
    static void dfs(int y, int x, int depth) {
        if(y==0 && x==M-1) {
            if(depth == K) {
                cnt++;
                return;
            }
        }

        for(int i=0; i<4; i++) {
            int y1 = y + dy[i];
            int x1 = x + dx[i];
            if(inRange(y1, x1) && !isVisited[y1][x1]) {
                isVisited[y1][x1] = true;
                dfs(y1, x1, depth+1);
                isVisited[y1][x1] = false;
            }
        }

    }
    static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }
}