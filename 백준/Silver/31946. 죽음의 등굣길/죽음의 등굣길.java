import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int X = Integer.parseInt(br.readLine());

        if (map[0][0] != map[N - 1][M - 1]) {
            System.out.println("DEAD");
            return;
        }

        int color = map[0][0];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        boolean isPossible = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == N - 1 && c == M - 1) {
                isPossible = true;
                break;
            }

            for (int nr = r - X; nr <= r + X; nr++) {
                for (int nc = c - X; nc <= c + X; nc++) {
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (Math.abs(r - nr) + Math.abs(c - nc) <= X) {
                            if (!visited[nr][nc] && map[nr][nc] == color) {
                                visited[nr][nc] = true;
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(isPossible ? "ALIVE" : "DEAD");
    }
}