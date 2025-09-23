import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int r, c, dir, turns;
        State(int r, int c, int dir, int turns) {
            this.r = r; this.c = c; this.dir = dir; this.turns = turns;
        }
    }

    static int N;
    static char[][] grid;
    static int[][][] dist;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        int startR = 0, startC = 0, endR = 0, endC = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'A') {
                    startR = i; startC = j;
                }
                if (grid[i][j] == 'B') {
                    endR = i; endC = j;
                }
            }
        }

        dist = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], 10001);
            }
        }

        // 0-1 BFS 구조 사용 (ArrayDeque. 같은 방향이면 addFirst, 회전이면 addLast)
        Deque<State> dq = new ArrayDeque<>();

        for (int d = 0; d < 4; d++) {
            dist[startR][startC][d] = 0;
            dq.add(new State(startR, startC, d, 0));
        }

        while (!dq.isEmpty()) {
            State cur = dq.poll();
            if (cur.r == endR && cur.c == endC) {
                System.out.println(cur.turns);
                return;
            }

            for (int nd = 0; nd < 4; nd++) {
                int nr = cur.r + dr[nd];
                int nc = cur.c + dc[nd];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (grid[nr][nc] == 'x') continue;

                int nturns = cur.turns + (cur.dir == nd ? 0 : 1);

                if (dist[nr][nc][nd] > nturns) {
                    dist[nr][nc][nd] = nturns;
                    if (cur.dir == nd)
                        dq.addFirst(new State(nr, nc, nd, nturns)); // 같은 방향, 회전 수 유지
                    else
                        dq.addLast(new State(nr, nc, nd, nturns));  // 다른 방향, 회전 수 +1
                }
            }
        }
    }
}
