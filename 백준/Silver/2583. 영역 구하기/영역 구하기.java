import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, areaCnt = 0;
    static int[][] map;
    static int[] result;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = -1;
                }
            }
        }

        bfs();

        result = new int[areaCnt + 1];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int areaNum = map[i][j];
                if (areaNum > 0) result[areaNum]++;
            }
        }
        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(areaCnt).append("\n");
        for (int i=1; i<=areaCnt; i++) sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] != 0) continue;
                areaCnt++;
                map[i][j] = areaCnt;
                q.add(new Node(i, j));

                while (!q.isEmpty()) {
                    Node cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = dr[dir] + cur.r;
                        int nc = dc[dir] + cur.c;
                        if (isValid(nr, nc) && map[nr][nc] == 0) {
                            map[nr][nc] = areaCnt;
                            q.add(new Node(nr, nc));
                        }
                    }
                }
            }
        }
    }
    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}