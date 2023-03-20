import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, tv, answer = 8*8;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<CCTV> cctvList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        if(tv == 0) {
            System.out.println(countBlindArea(map));
            System.exit(0);
        }
        dfs(0, map);
        System.out.println(answer);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] < 6) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        tv = cctvList.size();
    }
    private static void dfs(int depth, int[][] newMap) {
        if(depth == tv) {
            answer = Math.min(answer, countBlindArea(newMap));
            return;
        }
        int curR = cctvList.get(depth).r;
        int curC = cctvList.get(depth).c;
        int[][] temp;

        ArrayList<int[]>[] q = new ArrayList[4]; // [0] - 상, [1] - 하, [2] - 좌, [3] - 우
        for(int i = 0; i < 4; i++) {
            q[i] = new ArrayList<>();
            int nr = curR + dr[i];
            int nc = curC + dc[i];

            while(true) {
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 6) break;
                if(map[nr][nc] == 0)  q[i].add(new int[]{nr, nc});
                nr += dr[i];
                nc += dc[i];
            }
        }
        switch (map[curR][curC]) {
            case 1 : { // 한 방향만 보는 1번 카메라
                for(int dir = 0; dir < 4; dir++) {
                    temp = copy(newMap);
                    monitoring(q[dir], -1, temp);
                    dfs(depth + 1, temp);
                }
                break;
            }
            case 2 : { // 180도 두 방향을 보는 2번 카메라
                for(int dir = 0; dir <= 2; dir += 2) {
                    temp = copy(newMap);
                    monitoring(q[dir], -1, temp);
                    monitoring(q[dir+1], -1, temp);
                    dfs(depth + 1, temp);
                }
                break;
            }
            case 3 : { // 90도 두 방향을 보는 2번 카메라
                for(int dir = 0; dir < 2; dir++) {
                    temp = copy(newMap);
                    monitoring(q[dir], -1, temp);
                    monitoring(q[2], -1, temp);
                    dfs(depth + 1, temp);
                }
                for(int dir = 0; dir < 2; dir++) {
                    temp = copy(newMap);
                    monitoring(q[dir], -1, temp);
                    monitoring(q[3], -1, temp);
                    dfs(depth + 1, temp);
                }
                break;
            }
            case 4 : { // 세 방향을 보는 4번 카메라
                for(int dir=0; dir<4; dir++) {
                    temp = copy(newMap);
                    monitoring(q[dir], -1, temp);
                    monitoring(q[(dir+1)%4], -1, temp);
                    monitoring(q[(dir+2)%4], -1, temp);
                    dfs(depth + 1, temp);
                }
                break;
            }
            case 5 : { // 모든 방향을 보는 5번 카메라
                temp = copy(newMap);
                for(int dir=0; dir<4; dir++) {
                    monitoring(q[dir], -1, temp);
                }
                dfs(depth + 1, temp);
                break;
            }
        }
    }
    private static void monitoring(ArrayList<int[]> monitor, int onOff, int[][] tempMap) {
        for (int[] cur : monitor) {
            int r = cur[0];
            int c = cur[1];
            tempMap[r][c] = onOff;
        }
    }
    private static int countBlindArea(int[][] arr) {
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(arr[i][j] == 0) cnt++;
        return cnt;
    }
    private static int[][] copy(int[][] original) {
        int[][] tempArr = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                tempArr[i][j] = original[i][j];
            }
        }
        return tempArr;
    }
    private static class CCTV {
        int r;
        int c;
        int type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}