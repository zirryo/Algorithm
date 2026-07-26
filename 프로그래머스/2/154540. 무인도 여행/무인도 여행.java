import java.util.*;

class Solution {
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int totalFood = bfs(maps, i, j);
                    result.add(totalFood);
                }
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(String[] maps, int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int foodSum = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            foodSum += maps[x].charAt(y) - '0';

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return foodSum;
    }
}