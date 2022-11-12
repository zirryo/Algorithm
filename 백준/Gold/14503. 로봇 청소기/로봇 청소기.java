import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int r, c, d;
    static int cnt = 1; // 시작 위치는 항상 비어있으며 청소 가능
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0}; // 북 -> 동 -> 님 -> 서
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(cnt);
    }
    static void dfs(int y, int x, int d1) {
        map[y][x] = -1; // 청소한 곳 표시

        for(int i=0; i<4; i++) {
            d1 = (d1+3)%4; // 왼쪽으로 회전
            int y1 = y + dy[d1]; // 바라보는 방향으로 직진
            int x1 = x + dx[d1];

            if(inRange(y1, x1) && map[y1][x1] == 0) {
                cnt++;
                dfs(y1, x1, d1);
                return;
            }
        }
        int d2 = (d1+2)%4; // 후진하기 위해 방향 체크
        int y2 = y + dy[d2]; // 후진
        int x2 = x + dx[d2]; // 후진

        if(inRange(y2, x2) && map[y2][x2] != 1) {
            dfs(y2, x2, d1); // 후진할 때 실제로는 방향이 바뀌지 않으므로 변경전 값 입력
        }
    }
    static boolean inRange(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }

}