import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int height = 0;
    static int result = 0;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }

        int water = 0;
        while(height >= water) {
            int cnt = 0;
            isVisited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] > water && !isVisited[i][j]) {
                        cnt++; // 안전 지역 발견시 카운트
                        countArea(i, j, water);
                    }
                }
            }
            result = Math.max(cnt, result);
            water++;
        }
        System.out.println(result);

    }
    
    private static void countArea(int y, int x, int water) {
        isVisited[y][x] = true;
        for(int i=0; i<4; i++) {
            int y1 = y + dy[i];
            int x1 = x + dx[i];

            if(inRange(y1, x1)) {
                if(map[y1][x1] > water && !isVisited[y1][x1]) {
                    countArea(y1, x1, water);
                }
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<N;
    }

}