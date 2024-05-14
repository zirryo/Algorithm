import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1}; // 좌하우상
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int L = Integer.parseInt(st.nextToken());
            fireStorm(L);
            reduceIce();
        }

        int totalIce = getTotalIce();
        int largestBlock = getLagestBlock();
        System.out.println(totalIce + "\n" + largestBlock);
    }
    private static void fireStorm(int L) {
        int subSize = (int) Math.pow(2, L);
        for (int i = 0; i < size /subSize; i++) {
            for (int j = 0; j < size /subSize; j++) {
                turnMap(i * subSize, j * subSize, subSize);
            }
        }
    }
    private static void turnMap(int r, int c, int subSize) {
        int[][] temp = new int[subSize][subSize];
        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                temp[j][subSize-1-i] = map[r+i][c+j];
            }
        }
        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                map[r+i][c+j] = temp[i][j];
            }
        }
    }
    private static void reduceIce() {
        List<int[]> reduceList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 0) continue;
                int noIce = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr >= size || nc >= size || nr < 0 || nc < 0 || map[nr][nc] == 0) {
                        noIce++;
                    }
                }

                if (noIce > 1) {
                    reduceList.add(new int[]{i, j});
                }

            }
        }

        for (int[] arr : reduceList) {
            map[arr[0]][arr[1]]--;
        }
    }

    private static int getTotalIce() {
        int result = 0;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result += map[i][j];
            }
        }
        return result;
    }
    private static int getLagestBlock() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        return max;
    }
    private static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r ,c});
        int cnt = 0;

        while (!q.isEmpty()) {
            cnt++;
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= size || nc >= size || nr < 0 || nc < 0
                        || map[nr][nc] == 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        return cnt;
    }
}