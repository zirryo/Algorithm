import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result = 0;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));

        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            int walls = cur.wall;

            if(cur.r == N-1 && cur.c == M-1) {
                // 파괴한 벽의 수가 적은 Point 부터 poll 되므로 가장 처음 목적지에 도달한 경우가 최솟값
                result = walls;
                break;
            }

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

                if(!isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    
                    if(map[nr][nc] == 0) {
                        pq.add(new Point(nr, nc, walls));
                    }
                    else {
                        pq.add(new Point(nr, nc, walls+1));
                    }
                }
            }
        }

        System.out.println(result);
    }
}
class Point implements Comparable<Point> {
    int r;
    int c;
    int wall;

    public Point(int r, int c, int wall) {
        this.r = r;
        this.c = c;
        this.wall = wall;
    }

    @Override
    public int compareTo(Point po) {
        return this.wall - po.wall;
    }
}