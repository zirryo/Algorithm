import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, result;
    static int[][] map;
    static int[] enemy = new int[3];
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(enemy, 0, 0);
        System.out.println(result);
    }
    private static void combination(int[] e, int idx, int depth) {
        if(depth == 3) {
            attack(e);
            return;
        }
        for(int i = idx; i < M; i++) {
            e[depth] = i;
            combination(e, idx+1, depth+1);
            e[depth] = 0;
        }
    }
    private static void attack(int[] e) {
        int[][] tempMap = copyMap(map);
        int cnt = 0; // 제거한 적의 수
        ArrayList<Pos> kill;

        for(int i = N; i >= 1; i--) { // 턴(궁수 위치)
            kill = new ArrayList<>();
            if(!hasEnemy(tempMap, i)) break;
            for(int j = 0; j < 3; j++) { // 궁수
                if(tempMap[i-1][e[j]] == 1) {
                    kill.add(new Pos(i-1, e[j])); // 궁수 바로 위에 적이 있는 경우
                } else {
                    boolean[][] visited = new boolean[N][M];
                    visited[i-1][e[j]] = true;
                    Queue<Pos> q = new LinkedList<>();
                    q.add(new Pos(i-1, e[j]));
                    int killR = -1; // 죽일 적의 행
                    int killC = -1; // 죽일 적의 열
                    int killD = -1; // 죽일 적의 거리

                    while (!q.isEmpty()) {
                        Pos cur = q.poll();
                        for(int k = 0; k < 3; k++) {
                            int nr = cur.r + dr[k];
                            int nc = cur.c + dc[k];
                            if(nr >=0 && nc >= 0 && nr < i && nc < M) {
                                if(!visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    int dist = Math.abs(nr - i) + Math.abs(nc - e[j]);
                                    if(dist <= D && tempMap[nr][nc] == 1) {
                                        if(killD == -1 || killD > dist) { // 더 가까운 적을 찾은 경우
                                            killD = dist;
                                            killR = nr;
                                            killC = nc;
                                        } else if(killD == dist && killC > nc) { // 더 왼쪽에 위치한 경우
                                            killD = dist;
                                            killR = nr;
                                            killC = nc;
                                        }
                                    }
                                    if(dist < D) q.add(new Pos(nr, nc));
                                }
                            }
                        }
                    }
                    if(killR != -1 && killC != -1) kill.add(new Pos(killR, killC));
                }

            }
            for (Pos killed : kill) {
                if(tempMap[killed.r][killed.c] == 0) continue;
                tempMap[killed.r][killed.c] = 0;
                cnt++;
            }
        }
        result = Math.max(result, cnt);
    }
    private static int[][] copyMap(int[][] original) {
        int[][] copied = new int[N+1][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copied[i][j] = original[i][j];
            }
        }
        return copied;
    }
    private static boolean hasEnemy(int[][] arr, int archerIdx) {
        boolean flag = false;
        for(int i = 0; i < archerIdx; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}