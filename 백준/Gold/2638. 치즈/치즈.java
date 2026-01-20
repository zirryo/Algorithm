import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cheeseCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheeseCount++;
            }
        }

        int time = 0;
        while (cheeseCount > 0) {
            melt();
            time++;
        }

        System.out.println(time);
    }

    static void melt() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int[][] tempMap = new int[N][M];
        for(int i=0; i<N; i++) tempMap[i] = map[i].clone();

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (map[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        tempMap[nx][ny] = 2; // 외부 공기를 2로 표시
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 녹을 치즈 찾기
        ArrayList<int[]> toMelt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int airContact = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (tempMap[ni][nj] == 2) airContact++;
                    }
                    if (airContact >= 2) {
                        toMelt.add(new int[]{i, j});
                    }
                }
            }
        }

        // 치즈 녹이기
        for (int[] pos : toMelt) {
            if (map[pos[0]][pos[1]] == 1) {
                map[pos[0]][pos[1]] = 0;
                cheeseCount--;
            }
        }
    }
}