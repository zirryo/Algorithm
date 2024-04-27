import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean result = false;
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        if (result) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
    private static void dfs(int r, int c) {
        if (map[r][c] == -1) {
            result = true;
            return;
        }
        
        if (map[r][c] == 0) return;

        if (map[r][c] + r < N) {
            dfs(map[r][c] + r, c);
        }

        if (map[r][c] + c < N) {
            dfs(r, map[r][c] + c);
        }
    }
}