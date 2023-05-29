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
    static Pos destination;
    static Queue<Pos> hedgehog = new LinkedList<>();
    static Queue<Pos> water = new LinkedList<>();
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
                if(cur == 'X') map[i][j] = -1;
                else if(cur == 'S') {
                    map[i][j] = 1;
                    hedgehog.add(new Pos(i, j));
                }
                else if(cur == '*') {
                    map[i][j] = -2;
                    water.add(new Pos(i, j));
                } else if (cur == 'D') {
                    map[i][j] = -3;
                    destination = new Pos(i, j);
                }
            }
        }

        bfs();
        if(esc) System.out.println(cnt);
        else System.out.println("KAKTUS");
    }
    private static void bfs() { // 0:길, 1:고슴도치, -1:벽, -2:물
        // 물은 벽, 비버 소굴을 제외한 지역으로 퍼짐( 0, 1 이동 가능, -2로 마킹)
        // 지훈이는 벽, 물이 아닌 곳만 이동가능 (0으로만 이동, 갔던 곳은 1로 마킹)
        OuterLoop:
        while (true) {
            Queue<Pos> newWater = new LinkedList<>(); // 새로 확장된 물
            while (!water.isEmpty()) {
                Pos curWater = water.poll();
                for (int i=0; i<4; i++) {
                    int nr = dr[i] + curWater.r;
                    int nc = dc[i] + curWater.c;
                    if(valid(nr, nc) && map[nr][nc] > -1) {
                        map[nr][nc] = -2;
                        newWater.add(new Pos(nr, nc));
                    }
                }
            }
            water = newWater;

            Queue<Pos> nextPos = new LinkedList<>(); // 고슴도치의 이동 가능한 다음 위치
            while (!hedgehog.isEmpty()) {
                Pos curHedgehog = hedgehog.poll();
                if(escapeCheck(curHedgehog.r, curHedgehog.c)) break OuterLoop;
                for (int i=0; i<4; i++) {
                    int nr = dr[i] + curHedgehog.r;
                    int nc = dc[i] + curHedgehog.c;
                    if(valid(nr, nc) && (map[nr][nc] == 0 || map[nr][nc] == -3)) {
                        map[nr][nc] = 1;
                        nextPos.add(new Pos(nr, nc));
                    }
                }
            }
            if(nextPos.size() == 0) {
                break; // 이동 불가능하다면 -> KAKTUS
            }
            hedgehog = nextPos;
            cnt++;
        }
    }
    private static boolean escapeCheck(int r, int c) {
        if(r == destination.r && c == destination.c) {
            esc = true;
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