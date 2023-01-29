import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 0, -1, 1}; // {L, R, U, D}
    static int[] dc = {-1, 1, 0, 0}; // {L, R, U, D}
    static int[][] map;
    static boolean[][] grouped;
    static int N, M;
    static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        makeGroup();

        System.out.println(cnt);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        map = new int[N][M];
        grouped = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                char c = s.charAt(j);

                switch (c) {
                    case 'L' : {
                        map[i][j] = 0;
                        break;
                    }
                    case 'R' : {
                        map[i][j] = 1;
                        break;
                    }
                    case 'U' : {
                        map[i][j] = 2;
                        break;
                    }
                    case 'D' : {
                        map[i][j] = 3;
                        break;
                    }
                }
            }
        }
    }
    private static void makeGroup() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!grouped[i][j]) { // 그룹이 정해지지 않았다면
                    dfs(i, j);
                    cnt++;
                }
            }
        }
    }
    private static void dfs(int r, int c) {
        if(!inRange(r, c)) return;
        if(grouped[r][c]) return;

        grouped[r][c] = true;

        int dir = map[r][c];
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        dfs(nr, nc);

        // 현위치가 그룹의 시작점이 아닐수도 있으므로 인접 칸을 확인함.
        if(inRange(r, c+1) && map[r][c+1] == 0) dfs(r, c+1); // 우측칸의 방향이 L인 경우
        if(inRange(r, c-1) && map[r][c-1] == 1) dfs(r, c-1); // 좌측칸의 방향이 R인 경우
        if(inRange(r+1, c) && map[r+1][c] == 2) dfs(r+1, c); // 아랫칸의 방향이 U인 경우
        if(inRange(r-1, c) && map[r-1][c] == 3) dfs(r-1, c); // 윗칸의 방향이 D인 경우

    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

}