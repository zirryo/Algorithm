import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[501][501];
        boolean[][] visited = new boolean[501][501];
        int N = Integer.parseInt(br.readLine());
        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
                    map[i][j] = 1; // 위험한 구역
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
                    map[i][j] = -1; // 죽음의 구역
                }
            }
        }

        int result = -1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[2]));
        pq.add(new int[]{0, 0, 0}); // {x, y, life}
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == 500 && cur[1] == 500) {
                result = cur[2];
                break; // 우선순위 탐색이므로 가장 먼저 목적지에 도달한 경우 정답.
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx > 500 || ny < 0 || ny > 500 || visited[nx][ny]) continue;
                if (map[nx][ny] >= 0) {
                    visited[nx][ny] = true;
                    pq.add(new int[]{nx, ny, map[nx][ny] + cur[2]});
                }
            }
        }
        System.out.println(result);
    }
}