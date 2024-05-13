import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] sandRate = {1, 1, 7, 7, 10, 10, 2, 2, 5};
    static int[] dr = {0, 1, 0, -1}; // 좌하우상
    static int[] dc = {-1, 0, 1, 0};
    static int[][] spreadR = {
            {-1, 1, -1, 1, -1, 1, -2, 2, 0},
            {-1, -1, 0, 0, 1, 1, 0, 0, 2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0},
            {1, 1, 0, 0, -1, -1, 0, 0, -2}
    };
    static int[][] spreadC = {
            {1, 1, 0, 0, -1, -1, 0, 0, -2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0},
            {-1, -1, 0, 0, 1, 1, 0, 0, 2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0}
    };
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();
        System.out.println(result);
    }

    static void move() {
        int r = N / 2;
        int c = N / 2;
        int len = 1;
        int dir = 0;

        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < len; j++) {
                    r += dr[dir];
                    c += dc[dir];
                    spreadSand(r, c, dir);
                }
                dir = (dir + 1) % 4;
            }
            len++;

            if (len == N) {
                for (int i = 1; i < len; i++) {
                    r += dr[dir];
                    c += dc[dir];
                    spreadSand(r, c, dir);
                }
                break;
            }
        }
    }

    static void spreadSand(int r, int c, int dir) {
        int originalSand = map[r][c];
        for (int i = 0; i < 9; i++) {
            int nr = r + spreadR[dir][i];
            int nc = c + spreadC[dir][i];
            int movedSand = originalSand * sandRate[i] / 100;

            if (isInside(nr, nc)) {
                map[nr][nc] += movedSand;
            } else {
                result += movedSand;
            }
            map[r][c] -= movedSand;
        }

        int ar = r + dr[dir];
        int ac = c + dc[dir];

        if (isInside(ar, ac)) {
            map[ar][ac] += map[r][c];
        } else {
            result += map[r][c];
        }

        map[r][c] = 0;
    }

    static boolean isInside(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
