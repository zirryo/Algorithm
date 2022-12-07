import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result = 0;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][][] tetroU = {
            {{ 0, 0 }, { -1, -1 }, { -1, 0 }, { -1, 1 }}, // ㅜ
            {{ 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }}, // ㅓ
            {{ 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 }}, // ㅗ
            {{ 0, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }}  // ㅏ
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 0, 0);
                isVisited[i][j] = false;

                isU(i, j);
            }
        }
        System.out.println(result);

    }

    private static void dfs(int y, int x, int depth, int sum) { // ㅜ 를 제외한 나머지 조각들은 depth=4 dfs 
        if(depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        sum += map[y][x];

        for(int i=0; i<4; i++) {
            int y1 = y + dy[i];
            int x1 = x + dx[i];

            if(inRange(y1, x1) && !isVisited[y1][x1]) {
                isVisited[y1][x1] = true;
                dfs(y1, x1, depth+1, sum);
                isVisited[y1][x1] = false;
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }

    private static void isU(int y, int x) { // ㅜ 모양 조각은 따로 확인
        for(int i=0; i<4; i++) {
            int[][] u = tetroU[i];
            int temp = 0;

            for(int j=0; j<4; j++) {
                int y1 = y + u[j][0];
                int x1 = x + u[j][1];

                if(!inRange(y1, x1)) break; // 한 칸이라도 범위를 벗어나면 제외
                temp += map[y1][x1];

            }
            result = Math.max(result, temp);
        }
    }

}