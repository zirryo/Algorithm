import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
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
        makeWalls(0);
        System.out.println(result);
    }


    private static void makeWalls(int depth) {
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWalls(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        int[][] spread = new int[N][M]; // 벽을 세우는 위치마다 맵이 다름

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                spread[i][j] = map[i][j];
                if(spread[i][j] == 2) q.offer(new Pos(i, j));
            }
        }


        while (!q.isEmpty()) {
            Pos p = q.poll();

            for(int i=0; i<4; i++) {
                int y1 = p.y + dy[i];
                int x1 = p.x + dx[i];

                if(0<=y1 && y1<N && 0<=x1 && x1<M) {
                    if(spread[y1][x1] == 0) {
                        spread[y1][x1] = 2; // 바이러스 퍼뜨리기
                        q.offer(new Pos(y1, x1));
                    }
                }
            }
        }
        cntArea(spread);
    }

    private static void cntArea(int[][] arr) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) cnt++;
            }
        }
        result = Math.max(cnt, result);
    }

    public static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}