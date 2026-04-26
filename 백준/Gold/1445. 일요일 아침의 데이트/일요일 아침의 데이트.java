import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] isNearGarbage;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, gPass, gNear;

        Node(int r, int c, int gPass, int gNear) {
            this.r = r;
            this.c = c;
            this.gPass = gPass;
            this.gNear = gNear;
        }

        @Override
        public int compareTo(Node o) {
            if (this.gPass != o.gPass) return this.gPass - o.gPass;
            return this.gNear - o.gNear;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int startR = 0, startC = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    startR = i; startC = j;
                }
            }
        }

        isNearGarbage = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'g') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (map[nx][ny] == '.') isNearGarbage[nx][ny] = true;
                        }
                    }
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][][] cost = new int[N][M][2]; // [r][c][0: gPass, 1: gNear]

        for (int[][] row : cost) {
            for (int[] d : row) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }
        }

        pq.add(new Node(startR, startC, 0, 0));
        cost[startR][startC][0] = 0;
        cost[startR][startC][1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.gPass > cost[curr.r][curr.c][0]) continue;
            if (curr.gPass == cost[curr.r][curr.c][0] && curr.gNear > cost[curr.r][curr.c][1]) continue;

            if (map[curr.r][curr.c] == 'F') {
                System.out.println(curr.gPass + " " + curr.gNear);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dx[i];
                int nc = curr.c + dy[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    int nextGPass = curr.gPass + (map[nr][nc] == 'g' ? 1 : 0);
                    int nextGNear = curr.gNear + (map[nr][nc] == '.' && isNearGarbage[nr][nc] ? 1 : 0);

                    if (nextGPass < cost[nr][nc][0] || (nextGPass == cost[nr][nc][0] && nextGNear < cost[nr][nc][1])) {
                        cost[nr][nc][0] = nextGPass;
                        cost[nr][nc][1] = nextGNear;
                        pq.add(new Node(nr, nc, nextGPass, nextGNear));
                    }
                }
            }
        }
    }
}