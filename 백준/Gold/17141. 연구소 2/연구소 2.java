import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, result = 50 * 50;
    static int[][] map;
    static int[] selectedVirus;
    static List<Pos> candidate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        candidate = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) candidate.add(new Pos(i, j, 0));
            }
        }

        selectedVirus = new int[M];
        setVirus(0, 0);
        if (result == 50 * 50) System.out.println(-1);
        else System.out.println(result);
    }
    private static void setVirus(int depth, int idx) {
        if (depth == M) {
            spreadVirus();
            return;
        }

        for (int i = idx; i< candidate.size(); i++) {
            selectedVirus[depth] = i;
            setVirus(depth + 1, i + 1);
        }
    }
    private static void spreadVirus() {
        int maxCost = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int[][] copyMap = copyMap();
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            Pos cur = candidate.get(selectedVirus[i]);
            q.add(cur);
            copyMap[cur.r][cur.c] = 1;
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            maxCost = Math.max(maxCost, cur.cost);
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (copyMap[nr][nc] == 0) {
                    copyMap[nr][nc] = 2;
                    q.add(new Pos(nr, nc, cur.cost + 1));
                }
            }
        }

        if (allCovered(copyMap)) {
            result = Math.min(result, maxCost);
        }
    }
    private static int[][] copyMap() {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) copy[i][j] = 1;
            }
        }

        return copy;
    }
    private static boolean allCovered(int[][] used) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (used[i][j] == 0) return false;
            }
        }
        return true;
    }
}
class Pos {
    int r;
    int c;
    int cost;

    public Pos(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}