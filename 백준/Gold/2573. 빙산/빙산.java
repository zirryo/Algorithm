import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while(true) {

            int temp = island();

            if(temp >= 2) break;
            else if (temp == 0) {
                result = 0;
                break;
            }

            bfs();
            result++;
        }

        System.out.println(result);
    }

    static void dfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int y1 = y + dy[i];
            int x1 = x + dx[i];

            if(inRange(y1, x1) && !visited[y1][x1] && map[y1][x1] > 0) {
                dfs(y1, x1, visited);
            }
        }
    }

    static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] > 0) {
                    q.add(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Pos p = q.poll();

            int waterSide = 0;

            for(int i=0; i<4; i++) {
                int y1 = p.y + dy[i];
                int x1 = p.x + dx[i];

                if(inRange(y1, x1) && !visited[y1][x1] && map[y1][x1] == 0) {
                    waterSide++;
                }
            }

            if(map[p.y][p.x] < waterSide) map[p.y][p.x] = 0;
            else map[p.y][p.x] -= waterSide;
        }

    }

    static int island() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}