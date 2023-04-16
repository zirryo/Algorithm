import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int R, C, cnt = 0;
    static boolean esc;
    static Queue<Pos> sg;
    static Queue<Pos> fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            esc = false;
            cnt = 0;
            sg = new LinkedList<>();
            fire = new LinkedList<>();
            map = new int[R][C];

            for(int i=0; i<R; i++) {
                String s = br.readLine();
                for(int j=0; j<C; j++) {
                    char cur = s.charAt(j);
                    if(cur == '#') map[i][j] = -1;
                    else if(cur == '@') {
                        map[i][j] = 1;
                        sg.add(new Pos(i, j));
                    }
                    else if(cur == '*') {
                        map[i][j] = -2;
                        fire.add(new Pos(i, j));
                    }
                }
            }
            bfs();
            if(esc) sb.append(cnt).append("\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }
    private static void bfs() { // 0:길, 1:상근, -1:벽, -2:불
        // 불은 벽이 아니면 다 번질 수 있음( 0, 1 이동 가능, -2로 마킹)
        // 상근이는 벽, 불이 아닌 곳만 이동가능 (0으로만 이동, 갔던 곳은 1로 마킹)
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

            Queue<Pos> newSG = new LinkedList<>(); // 상근이의 이동 가능한 다음 위치
            while (!sg.isEmpty()) {
                Pos curSG = sg.poll();
                if(escapeCheck(curSG.r, curSG.c)) break OuterLoop;
                for (int i=0; i<4; i++) {
                    int nr = dr[i] + curSG.r;
                    int nc = dc[i] + curSG.c;
                    if(valid(nr, nc) && map[nr][nc] == 0) {
                        if(map[nr][nc] != -2) map[nr][nc] = 1;
                        newSG.add(new Pos(nr, nc));
                    }
                }
            }
            if(newSG.size() == 0) {
                break; // 이동 불가능하다면 -> IMPOSSIBLE
            }
            sg = newSG;
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