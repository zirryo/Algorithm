import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] columnOil = new int[m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int oilVol = 0;
                    boolean[] includedCols = new boolean[m];
                    Queue<int[]> q = new ArrayDeque<>();

                    visited[i][j] = true;
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];

                        oilVol++;
                        includedCols[c] = true;

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (land[nr][nc] == 1 && !visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    q.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }

                    for (int c = 0; c < m; c++) {
                        if (includedCols[c]) {
                            columnOil[c] += oilVol;
                        }
                    }
                }
            }
        }

        int maxOil = 0;
        for (int oil : columnOil) {
            maxOil = Math.max(maxOil, oil);
        }

        return maxOil;
    }
}