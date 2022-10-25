import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0,0,1)); // 시작위치
        isVisited[0][0] = true;

        while(!q.isEmpty()) {
            Position p = q.poll();
            for(int i=0; i<4; i++) {
                int y1 = p.y + dy[i];
                int x1 = p.x + dx[i];

                if(y1==N-1 && x1==M-1) {
                    System.out.println(p.count+1); // 좌표 (N,M)도 카운트 하기 위해 +1
                    System.exit(0);
                }

                if(inRange(y1, x1)) {
                    if(map[y1][x1]==1 && !isVisited[y1][x1]) {
                        q.offer(new Position(y1, x1, p.count+1));
                        isVisited[y1][x1] = true;
                    }
                }
            }
        }
    }

    static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }

    public static class Position {
        int y;
        int x;
        int count;

        public Position(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}