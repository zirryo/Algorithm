import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T  = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 10001;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || map[x][y] == 1) continue;
                visited[x][y] = true;
                q.add(new int[]{x, y, cur[2] + 1});
                if (map[x][y] == 2) {
                    result = Math.min(result, cur[2] + 1 + Math.abs(x - (N-1)) + Math.abs(y - (M-1)));
                }
                if (x == N-1 && y == M-1) {
                    result = Math.min(result, cur[2] + 1);
                    break;
                }
            }
        }

        if (result <= T) System.out.println(result);
        else System.out.println("Fail");
    }
}
