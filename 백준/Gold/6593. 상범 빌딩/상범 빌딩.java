import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int[] dx = {0, 0, 0, 1, 0, -1};
    static int[][][] map;
    static int Z, Y, X;
    static Node start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            Z = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            if (Z == 0 && Y == 0 && X == 0) break;

            map = new int[Z][Y][X];

            for (int i = 0; i < Z; i++) {
                for (int j = 0; j < Y; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < X; k++) {
                        char c = s.charAt(k);

                        if (c == 'S') start = new Node(i, j, k);
                        else if (c == '#') map[i][j][k] = -1;
                        else {
                            if (c == 'E') end = new Node(i, j, k);
                            map[i][j][k] = 30 * 30 * 30;
                        }
                    }
                }
                br.readLine(); // 층 사이 공백
            }
            bfs();

            if (map[end.z][end.y][end.x] == (30 * 30 * 30)) sb.append("Trapped!");
            else sb.append("Escaped in ").append(map[end.z][end.y][end.x]).append(" minute(s).");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = dz[i] + cur.z;
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if (nz < 0 || ny < 0 || nx < 0 || nz >= Z || ny >= Y || nx >= X) continue;
                if (map[nz][ny][nx] == -1) continue;
                if (map[nz][ny][nx] <= map[cur.z][cur.y][cur.x] + 1) continue;
                map[nz][ny][nx] = map[cur.z][cur.y][cur.x] + 1;
                q.add(new Node(nz, ny, nx));
            }
        }
    }
}
class Node {
    int z;
    int y;
    int x;

    public Node(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}
