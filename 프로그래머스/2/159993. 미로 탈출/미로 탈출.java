import java.util.*;

class Solution {
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') start = new int[]{i, j};
                else if (c == 'L') lever = new int[]{i, j};
                else if (c == 'E') exit = new int[]{i, j};
            }
        }

        int dist1 = bfs(maps, start, lever);
        if (dist1 == -1) return -1;

        int dist2 = bfs(maps, lever, exit);
        if (dist2 == -1) return -1;

        return dist1 + dist2;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == target[0] && y == target[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}