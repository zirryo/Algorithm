import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[][] box;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1) {
                    q.offer(i);
                    q.offer(j);
                }
            }
        }

        while(!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for(int i=0; i<4; i++) {
                int y0 = y + dy[i];
                int x0 = x + dx[i];

                if(inRange(y0, x0) && box[y0][x0]==0) {
                    q.offer(y0);
                    q.offer(x0);
                    box[y0][x0] = box[y][x] + 1;
                }
            }
        }

        int days = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                days = Math.max(days, box[i][j]);
            }
        }
        if(days==1) System.out.println(0);
        else System.out.println(days-1); // box에서 토마토가 있는 곳 초기값이 1이므로 최소날짜는 days-1

    }
    static boolean inRange(int y, int x) {
        if(x>=0 && x<M && y>=0 && y<N) return true;
        return false;
    }
}