import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, R;
    static ArrayList<Node>[][] roads;
    static boolean[][] cow;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        roads = new ArrayList[N+1][N+1];
        cow = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                roads[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r0 = Integer.parseInt(st.nextToken());
            int c0 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            roads[r0][c0].add(new Node(r1, c1));
            roads[r1][c1].add(new Node(r0, c0));
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cow[r][c] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cow[i][j]) bfs(i, j);
            }
        }

        System.out.print(result / 2);
    }
    private static void bfs(int r, int c) {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int cnt = -1;
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cow[cur.r][cur.c]) cnt++;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr <= 0 || nr > N || nc <= 0 || nc > N || visited[nr][nc]) continue;
                boolean flag = true;
                for (Node next : roads[cur.r][cur.c]) {
                    if (next.r == nr && next.c == nc) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        result += (K - cnt - 1);
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