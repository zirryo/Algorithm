import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map1, map2;
    static boolean[][] visited;
    static boolean hasError = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map1 = new int[N][M];
        map2 = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (checkVaccine()) System.out.println("YES");
        else System.out.println("NO");
    }
    private static boolean checkVaccine() {
        int changedBlock = 0; // 단 하나의 항체만 동작해야 함.

        Outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (bfs(i, j)) changedBlock++;
                if (changedBlock > 1) break Outer;
            }
        }
//        System.out.println("changedBlock = " + changedBlock);
//        System.out.println("hasError = " + hasError);

        if (!hasError && changedBlock <= 1) return true;
        else return false;
    }
    private static boolean bfs(int r, int c) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int data = map1[r][c];
        int postData = map2[r][c];
        boolean changedNum = false;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (postData != map2[cur[0]][cur[1]]) hasError = true;
            if (map1[cur[0]][cur[1]] != map2[cur[0]][cur[1]]) changedNum = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || data != map1[nr][nc]) continue;
                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return changedNum;
    }
}