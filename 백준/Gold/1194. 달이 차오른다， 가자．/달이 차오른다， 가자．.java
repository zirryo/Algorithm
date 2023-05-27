import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][][] visited;
    static Node start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[64][n][m]; // 열쇠 6개를 비트마스킹 (a: 1, b: 2, c: 4, d: 8, e: 16, f: 32)

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') start = new Node(i, j, 0, 0);
            }
        }
        int result = bfs();
        System.out.println(result);
    }
    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[0][start.r][start.c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (map[cur.r][cur.c] == '1') return cur.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isValid(nr, nc) || map[nr][nc] == '#' || visited[cur.key][nr][nc]) continue;
                if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
                    visited[cur.key][nr][nc] = true;
                    q.add(new Node(nr, nc, cur.cnt + 1, cur.key));
                } else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 열쇠
                    int newKey = (1 << map[nr][nc] - 'a');
                    newKey = newKey | cur.key; // 키는 여러번 사용 가능, 기존 보유 키와 OR 연산

                    if (visited[newKey][nr][nc]) continue;
                    visited[newKey][nr][nc] = true;
                    q.add(new Node(nr, nc, cur.cnt + 1, newKey));
                } else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F')  { // 문
                    int newDoor = (1 << map[nr][nc] - 'A');
                    if ((cur.key & newDoor) != 0) {
                        visited[cur.key][nr][nc] = true;
                        q.add(new Node(nr, nc, cur.cnt + 1, cur.key));
                    }
                }
            }
        }

        return -1;
    }
    private static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
    private static class Node {
        int r;
        int c;
        int cnt;
        int key;

        public Node(int r, int c, int cnt, int key) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.key = key;
        }
    }
}