import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = (s.charAt(j) == 'W') ? 0 : 1;
            }
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1) {
                    isVisited = new boolean[N][M]; // 모든 육지에서 각각 bfs 를 수행하여 최단거리를 구함
                    int temp = bfs(i, j);
                    result = Math.max(temp, result);
                }
            }
        }
        System.out.println(result);
    }
    private static int bfs(int y, int x) {
        isVisited[y][x] = true;
        int temp = 0;

        Queue<land> q = new LinkedList<>();
        q.offer(new land(y, x, 0));

        while(!q.isEmpty()) {
            land l = q.poll();
            for(int i=0; i<4; i++) {
                int y1 = l.y + dy[i];
                int x1 = l.x + dx[i];
                if(inRange(y1, x1)) {
                    if(map[y1][x1]==1 && !isVisited[y1][x1]) {
                        isVisited[y1][x1] = true;
                        q.offer(new land(y1, x1, l.count+1));
                        temp = Math.max(temp, l.count+1);
                    }
                }
            }
        }
        return temp;
    }

    private static boolean inRange(int y, int x) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
    public static class land {
        int y;
        int x;
        int count;

        public land(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}