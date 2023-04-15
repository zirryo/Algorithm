import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int R, C, cnt = 0;
    static boolean esc = false;
    static Queue<Pos> JH = new LinkedList<>();
    static Queue<Pos> fire = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                char cur = s.charAt(j);
                if(cur == '#') map[i][j] = -1;
                else if(cur == 'J') {
                    map[i][j] = 1;
                    JH.add(new Pos(i, j));
                }
                else if(cur == 'F') {
                    map[i][j] = -2;
                    fire.add(new Pos(i, j));
                }
            }
        }

        bfs();
        if(esc) System.out.println(cnt);
        else System.out.println("IMPOSSIBLE");
    }
    private static void bfs() { // 0:길, 1:지훈, -1:벽, -2:불
        // 불은 벽이 아니면 다 번질 수 있음( 0, 1 이동 가능, -2로 마킹)
        // 지훈이는 벽, 불이 아닌 곳만 이동가능 (0으로만 이동, 갔던 곳은 1로 마킹)
        OuterLoop:
        while (true) {
            Queue<Pos> newFire = new LinkedList<>(); // 새로 붙은 불
            while (!fire.isEmpty()) {
                Pos curFire = fire.poll();
                for (int i=0; i<4; i++) {
                    int nr = dr[i] + curFire.r;
                    int nc = dc[i] + curFire.c;
                    if(valid(nr, nc) && map[nr][nc] > -1) {
                        map[nr][nc] = -2;
                        newFire.add(new Pos(nr, nc));
                    }
                }
            }
            fire = newFire;

            Queue<Pos> newJH = new LinkedList<>(); // 지훈이의 이동 가능한 다음 위치
            while (!JH.isEmpty()) {
                Pos curJH = JH.poll();
                if(escapeCheck(curJH.r, curJH.c)) break OuterLoop;
                for (int i=0; i<4; i++) {
                    int nr = dr[i] + curJH.r;
                    int nc = dc[i] + curJH.c;
                    if(valid(nr, nc) && map[nr][nc] == 0) {
                        if(map[nr][nc] != -2) map[nr][nc] = 1;
                        newJH.add(new Pos(nr, nc));
                    }
                }
            }
            if(newJH.size() == 0) {
                break; // 이동 불가능하다면 -> IMPOSSIBLE
            }
            JH = newJH;
            cnt++;
        }
    }
    private static boolean escapeCheck(int r, int c) {
        if(r == 0 || c == 0 || r == R-1 || c == C-1) {
            esc = true;
            cnt++;
            return true;
        }
        return false;
    }
    private static boolean valid(int r, int c) {
        return r>=0 && r<R && c>=0 && c<C;
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