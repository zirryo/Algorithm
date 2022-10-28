import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        Queue<Position> q = new LinkedList<>();

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) q.offer(new Position(i, j, k));
                }
            }
        }

        while(!q.isEmpty()) {
            Position p = q.poll();
            for(int i=0; i<6; i++) {
                int z0 = p.z + dz[i];
                int y0 = p.y + dy[i];
                int x0 = p.x + dx[i];

                if(inRange(z0, y0, x0) && box[z0][y0][x0]==0) {
                    q.offer(new Position(z0, y0, x0));
                    box[z0][y0][x0] = box[p.z][p.y][p.x] + 1;
                }
            }
        }

        int days = 0;
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    days = Math.max(days, box[i][j][k]);
                }
            }
        }
        if(days==1) System.out.println(0);
        else System.out.println(days-1);
    }

    static boolean inRange(int z, int y, int x) {
        return z>=0 && z<H && y>=0 && y<N && x>=0 && x<M;
    }

    public static class Position {
        int z;
        int y;
        int x;

        public Position(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}