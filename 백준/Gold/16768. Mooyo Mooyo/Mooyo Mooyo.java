import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][10];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        while (true) {
            boolean playMore = false;
            visited = new boolean[N][10];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 10; j++) {
                    if (grid[i][j] != 0 && !visited[i][j]) {
                        List<int[]> cells = new ArrayList<>();
                        dfs(i, j, grid[i][j], cells);
                        if (cells.size() >= K) {
                            playMore = true;
                            for (int[] cell : cells) {
                                grid[cell[0]][cell[1]] = 0;
                            }
                        }
                    }
                }
            }

            if (!playMore) break;
            dropBlocks();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int x, int y, int color, List<int[]> group) {
        visited[x][y] = true;
        group.add(new int[]{x, y});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < 10 && grid[nx][ny] == color && !visited[nx][ny]) {
                dfs(nx, ny, color, group);
            }
        }
    }

    private static void dropBlocks() {
        for (int j = 0; j < 10; j++) {
            int ground = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    int temp = grid[i][j];
                    grid[i][j] = 0;
                    grid[ground][j] = temp;
                    ground--;
                }
            }
        }
    }
}