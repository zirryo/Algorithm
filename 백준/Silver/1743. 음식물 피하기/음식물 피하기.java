import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] isVisited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        while(K-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
        }

        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==1 && !isVisited[i][j]) {
                    count = 1;
                    countTrash(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }

    private static int countTrash(int y, int x) {
        isVisited[y][x] = true;

        for(int i=0; i<4; i++) {
            int y0 = y + dy[i];
            int x0 = x + dx[i];

            if(inRange(y0, x0)) {
                if(map[y0][x0]==1 && !isVisited[y0][x0]) {
                    count++;
                    countTrash(y0, x0);
                }
            }
        }
        return count;
    }

    private static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }

}