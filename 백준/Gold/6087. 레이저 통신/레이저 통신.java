import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int result;
    static final int INF = 1000 * 1000;
    static int[][] map;
    static int[][][] cost;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static Point start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        result = INF;

        map = new int[H][W];
        cost = new int[H][W][4];

        boolean flag = false;

        for(int i=0; i<H; i++) {
            String s = br.readLine();
            for(int j=0; j<W; j++) {
                Arrays.fill(cost[i][j], INF);

                char c = s.charAt(j);
                if(c == '*') map[i][j] = -1;
                else if(c == 'C') {
                    map[i][j] = 1;

                    if(flag) {
                        end = new Point(i, j, -3, -1);
                    } else {
                        start = new Point(i, j, -3, -1);
                        Arrays.fill(cost[i][j], 0);
                        flag = true;
                    }
                }
            }
        }
        dijkstra();
        System.out.println(result);
    }
    static void dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(start);

        while(!pq.isEmpty()) {
            Point cur = pq.poll();

            if(cur.r == end.r && cur.c == end.c) {
                result = Math.min(result, cur.cnt);
                continue;
            }

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int tempCnt = cur.cnt;

                if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc] == -1 || Math.abs(cur.dir - i) == 2) continue;
                if(cur.dir != i) tempCnt++; // 레이저 방향과 이동방향 맞추기
                if(cost[nr][nc][i] > tempCnt) { // 거울 수가 더 작을 경우 큐에 추가
                    cost[nr][nc][i] = tempCnt;
                    pq.add(new Point(nr, nc, i, tempCnt));
                }
            }
        }
    }
}

class Point implements Comparable<Point> {
    int r;
    int c;
    int dir; // 현재 방향
    int cnt; // 거울 수

    public Point(int r, int c, int dir, int cnt) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point p) {
        return this.cnt - p.cnt;
    }
}