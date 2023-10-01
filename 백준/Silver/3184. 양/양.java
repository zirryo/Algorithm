import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int sheep = 0;
        int wolf = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        boolean[][] visited = new boolean[R][C];
        Queue<Node> q;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (map[i][j] == '#') continue;
                int tempS = 0;
                int tempW = 0;
                q = new LinkedList<>();
                q.add(new Node(i, j));

                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    if (map[cur.r][cur.c] == 'o') tempS++;
                    else if (map[cur.r][cur.c] == 'v') tempW++;

                    for (int k=0; k<4; k++) {
                        int nr = dr[k] + cur.r;
                        int nc = dc[k] + cur.c;
                        if (nr < 0 || nc < 0 || nr >= R || nc >= C
                                || visited[nr][nc] || map[nr][nc] == '#') continue;
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc));
                    }
                }

                if (tempS > tempW) sheep += tempS;
                else wolf += tempW;
            }
        }

        System.out.println(sheep + " " + wolf);
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