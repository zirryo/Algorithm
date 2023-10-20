import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] banner;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        banner = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (banner[i][j] == 0) continue;
                bfs(i, j);
                result++;
            }
        }

        System.out.println(result);
    }
    private static void bfs(int r, int c) {
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        banner[r][c] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i=0; i<8; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || banner[nr][nc] == 0) continue;
                q.add(new Node(nr, nc));
                banner[nr][nc] = 0;
            }
        }
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