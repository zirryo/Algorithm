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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[][] board = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        Queue<Point> q = new LinkedList<>();

        Outer:
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == '2') {
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                    break Outer;
                }
            }
        }

        boolean available = false;
        int minDist = 0;

        Outer2:
        while (!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || board[x][y] == '1') continue;
                if (board[x][y] == '0') {
                    visited[x][y] = true;
                    q.add(new Point(x, y, p.dist + 1));
                } else {
                    available = true;
                    minDist = p.dist + 1;
                    break Outer2;
                }
            }
        }

        if (available) System.out.println("TAK\n" + minDist);
        else System.out.println("NIE");

    }
}
class Point {
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
