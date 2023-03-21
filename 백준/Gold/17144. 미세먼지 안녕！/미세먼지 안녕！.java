import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map;
    static ArrayList<Integer> purifiers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();

        while(T-- > 0) {
            spread(); // 미세먼지 확산
            purify(); // 공기 청정기 가동
        }
        System.out.println(countDust());
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) purifiers.add(i);
            }
        }

    }
    private static void spread() {
        int[][] temp = new int[R][C];
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }
                temp[i][j] += map[i][j];
                for(int k=0; k<4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] == -1) continue;

                    temp[nr][nc] += (map[i][j] / 5);
                    temp[i][j] -= (map[i][j] / 5);
                }
            }
        }
        map = temp;
    }
    private static void purify() {
        int top = purifiers.get(0);

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x-1][0];
        }
        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y+1];
        }
        for (int x = 0; x < top; x++) {
            map[x][C-1] = map[x+1][C-1];
        }
        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y-1];
        }
        map[top][1] = 0; // 정화된 공기 배출


        int bottom = purifiers.get(1);

        for (int x = bottom + 1; x < R - 1; x++) {
            map[x][0] = map[x+1][0];
        }
        for (int y = 0; y < C - 1; y++) {
            map[R-1][y] = map[R-1][y+1];
        }
        for (int x = R - 1; x > bottom; x--) {
            map[x][C-1] = map[x-1][C-1];
        }
        for (int y = C - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y-1];
        }
        map[bottom][1] = 0; // 정화된 공기 배출
    }
    private static int countDust() {
        int totalDust = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                totalDust += map[i][j];
            }
        }
        return totalDust + 2; // 공기청정기 자리의 합 == -2
    }
}