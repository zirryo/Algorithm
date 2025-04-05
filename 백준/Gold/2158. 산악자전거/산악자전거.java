import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c;
        double time, speed;

        Node(int r, int c, double time, double speed) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.speed = speed;
        }

        public int compareTo(Node o) {
            return Double.compare(this.time, o.time);
        }
    }

    static int R, C;
    static int[][] height;
    static double[][] minTime;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double V = Double.parseDouble(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        height = new int[R][C];
        minTime = new double[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                minTime[i][j] = Double.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0.0, V));
        minTime[0][0] = 0.0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time > minTime[cur.r][cur.c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                double nextTime = cur.time + 1.0 / cur.speed;

                int diff = height[cur.r][cur.c] - height[nr][nc];
                double nextSpeed = cur.speed * Math.pow(2, diff);

                if (nextTime < minTime[nr][nc]) {
                    minTime[nr][nc] = nextTime;
                    pq.offer(new Node(nr, nc, nextTime, nextSpeed));
                }
            }
        }

        System.out.print(minTime[R - 1][C - 1]);
    }
}
