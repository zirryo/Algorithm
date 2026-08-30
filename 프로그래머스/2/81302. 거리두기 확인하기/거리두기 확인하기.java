import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = checkPlace(places[i]);
        }

        return answer;
    }

    private int checkPlace(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(r, c, place)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean bfs(int startR, int startC, String[] place) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (dist == 2) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    char next = place[nr].charAt(nc);

                    if (next == 'X') continue;

                    if (next == 'P') {
                        return false;
                    }

                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return true;
    }
}