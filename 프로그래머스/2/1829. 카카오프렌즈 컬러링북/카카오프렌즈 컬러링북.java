import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea++;
                    int areaSize = bfs(i, j, m, n, picture, visited);
                    maxSizeOfArea = Math.max(maxSizeOfArea, areaSize);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfArea};
    }

    private int bfs(int startR, int startC, int m, int n, int[][] picture, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int targetColor = picture[startR][startC];
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (!visited[nr][nc] && picture[nr][nc] == targetColor) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}