import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int INF = 300 * 300;
    static int[][] map;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static Node start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(moveKnight(start, end)).append("\n");
        }
        System.out.println(sb);
    }
    private static int moveKnight(Node s, Node e) {
        map = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(map[i], INF);

        Queue<Node> q = new LinkedList<>();
        q.add(s);
        map[s.r][s.c] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == e.r && cur.c == e.c) return map[cur.r][cur.c];

            for (int i = 0; i < 8; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;

                if (invalid(nr, nc)) continue;
                if (map[nr][nc] > map[cur.r][cur.c] + 1) {
                    map[nr][nc] = map[cur.r][cur.c] + 1;
                    q.add(new Node(nr, nc));
                }
            }
        }

        return 0;
    }
    private static boolean invalid(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
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