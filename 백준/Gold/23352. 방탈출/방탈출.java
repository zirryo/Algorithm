import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited; // 전체 컴포넌트 방문용
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        int globalMaxDist = -1;
        int globalMaxSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    List<int[]> component = collectComponent(i, j);
                    int k = component.size();
                    for (int a = 0; a < k; a++) {
                        int sx = component.get(a)[0];
                        int sy = component.get(a)[1];

                        int[][] dist = new int[N][M];
                        for (int l = 0; l < N; l++) {
                            Arrays.fill(dist[l], -1);
                        }
                        ArrayDeque<int[]> q = new ArrayDeque<>();
                        dist[sx][sy] = 0;
                        q.add(new int[]{sx, sy});

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int cx = cur[0], cy = cur[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = cx + dx[d], ny = cy + dy[d];
                                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                                if (map[nx][ny] == 0) continue;
                                if (dist[nx][ny] != -1) continue;
                                dist[nx][ny] = dist[cx][cy] + 1;
                                q.add(new int[]{nx, ny});
                            }
                        }

                        for (int b = a; b < k; b++) {
                            int tx = component.get(b)[0];
                            int ty = component.get(b)[1];
                            int d = dist[tx][ty];
                            if (d == -1) continue;
                            int sum = map[sx][sy] + map[tx][ty];

                            if (d > globalMaxDist) {
                                globalMaxDist = d;
                                globalMaxSum = sum;
                            } else if (d == globalMaxDist) {
                                if (sum > globalMaxSum) globalMaxSum = sum;
                            }
                        }
                    }
                }
            }
        }

        if (globalMaxDist == -1) {
            System.out.println(0);
        } else {
            System.out.println(globalMaxSum);
        }
    }

    static List<int[]> collectComponent(int sx, int sy) {
        List<int[]> comp = new ArrayList<>();
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            comp.add(cur);
            int cx = cur[0], cy = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return comp;
    }
}
