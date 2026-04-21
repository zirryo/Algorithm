import java.io.*;
import java.util.*;

public class Main {
    static int N, M, landX, landY, P;
    static int[][] W;
    static boolean[][] visited;
    static int maxWater = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        W = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        landX = Integer.parseInt(st.nextToken());
        landY = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        visited[landX][landY] = true;

        for (int i = 0; i < 4; i++) {
            int nx = landX + dx[i];
            int ny = landY + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (P >= 1) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, P - 1, i, W[landX][landY] + W[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }

        if (maxWater == 0) maxWater = W[landX][landY];

        System.out.println(maxWater);
    }

    static void dfs(int x, int y, int remainP, int prevDir, int waterSum) {
        maxWater = Math.max(maxWater, waterSum);

        if (remainP <= 0) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                int curCost = (prevDir == i) ? 1 : 2;

                if (remainP >= curCost) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, remainP - curCost, i, waterSum + W[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}