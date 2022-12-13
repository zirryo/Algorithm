import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1987 알파벳
public class Main {
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] map;
    static boolean[] isVisited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isVisited = new boolean[26];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }
        dfs(1, 0, 0);
        System.out.println(result);

    }
    static void dfs(int depth, int r, int c) {
        isVisited[map[r][c]] = true;
        result = Math.max(depth, result);

        for(int i=0; i<4; i++) {
            int r1 = r + dr[i];
            int c1 = c + dc[i];

            if(inRange(r1, c1) && !isVisited[map[r1][c1]]) {
                dfs(depth+1, r1, c1);
                isVisited[map[r1][c1]] = false;
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<R && c>=0 && c<C;
    }

}