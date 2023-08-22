import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] vanish;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<Node> cloud, moved;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cloud = new ArrayList<>();
        moved = new ArrayList<>();
        cloud.add(new Node(N-1, 0));
        cloud.add(new Node(N-1, 1));
        cloud.add(new Node(N-2, 0));
        cloud.add(new Node(N-2, 1));

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            moveCloud(d - 1, s);
            vanish = new boolean[N][N];
            rainAndWaterCopy();
            makeCloud();
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
    }
    private static void makeCloud() {
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                if (map[i][j] >= 2 && !vanish[i][j]) {
                    map[i][j] -= 2;
                    cloud.add(new Node(i, j));
                }
            }
        }
    }
    private static void rainAndWaterCopy() {
        for (Node cur : moved) {
            vanish[cur.r][cur.c] = true;
            map[cur.r][cur.c]++;
        }

        for (Node cur : moved) {
            int cnt = 0;
            for (int i = 1; i < 8; i += 2) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] <= 0) continue;
                cnt++;
            }
            map[cur.r][cur.c] += cnt;
        }
        moved.clear();
    }
    private static void moveCloud(int d, int s) {
        for (Node cur : cloud) {
            int nr = cur.r + s * dr[d];
            int nc = cur.c + s * dc[d];
            moved.add(new Node(relocate(nr), relocate(nc)));
        }
        cloud.clear();
    }
    private static int relocate(int x) {
        if (x % N == 0) return 0;
        else if (x < 0) return x % N + N;
        else return x % N;
    }
}
class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}