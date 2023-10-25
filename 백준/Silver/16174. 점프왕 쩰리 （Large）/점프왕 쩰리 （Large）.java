import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int[] dr = {0, 1};
        int[] dc = {1, 0};
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Node(0, 0));
        boolean flag = false;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (map[cur.r][cur.c] == -1) {
                flag = true;
                break;
            }

            for (int i = 0; i < 2; i++) {
                int nr = cur.r + dr[i] * map[cur.r][cur.c];
                int nc = cur.c + dc[i] * map[cur.r][cur.c];
                if (nr >= N || nc >= N || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new Node(nr, nc));
            }
        }

        if (flag) System.out.println("HaruHaru");
        else System.out.println("Hing");
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