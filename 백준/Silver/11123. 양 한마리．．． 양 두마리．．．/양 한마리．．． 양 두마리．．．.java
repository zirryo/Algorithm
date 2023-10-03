import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            for (int j = 0; j < R; j++) {
                map[j] = br.readLine().toCharArray();
            }
            sb.append(bfs()).append("\n");
        }

        System.out.print(sb);
    }
    private static int bfs() {
        Queue<Node> q;
        boolean[][] visited = new boolean[R][C];
        int cnt = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (map[i][j] == '.') continue;
                cnt++;
                q = new LinkedList<>();
                q.add(new Node(i, j));

                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nr = dr[k] + cur.r;
                        int nc = dc[k] + cur.c;
                        if (nr < 0 || nc < 0 || nr >= R || nc >= C
                                || visited[nr][nc] || map[nr][nc] == '.') continue;
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc));
                    }
                }
            }
        }
        return cnt;
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