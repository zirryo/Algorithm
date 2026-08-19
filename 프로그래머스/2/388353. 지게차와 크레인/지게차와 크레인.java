import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] map = new char[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                map[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (String req : requests) {
            char target = req.charAt(0);

            if (req.length() == 1) { 
                boolean[][] isOutside = new boolean[n + 2][m + 2];
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{0, 0});
                isOutside[0][0] = true;

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int r = curr[0];
                    int c = curr[1];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < n + 2 && nc >= 0 && nc < m + 2) {
                            if (!isOutside[nr][nc] && map[nr][nc] == '.') {
                                isOutside[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }

                List<int[]> toRemove = new ArrayList<>();
                for (int r = 1; r <= n; r++) {
                    for (int c = 1; c <= m; c++) {
                        if (map[r][c] == target) {
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];
                                if (isOutside[nr][nc]) {
                                    toRemove.add(new int[]{r, c});
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int[] pos : toRemove) {
                    map[pos[0]][pos[1]] = '.';
                }

            } else { 
                for (int r = 1; r <= n; r++) {
                    for (int c = 1; c <= m; c++) {
                        if (map[r][c] == target) {
                            map[r][c] = '.';
                        }
                    }
                }
            }
        }

        int remain = 0;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (map[r][c] != '.') {
                    remain++;
                }
            }
        }

        return remain;
    }
}