import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] temp = new int[6];
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        arr = new int[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0);
            }
        }
        System.out.println(set.size());
    }
    private static void dfs(int r, int c, int depth) {
        if (depth == 6) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                s.append(temp[i]);
            }

            set.add(s.toString());
            return;
        }

        temp[depth] = arr[r][c];
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if (nr < 0 || nr >=5 || nc < 0 || nc >= 5) continue;
            dfs(nr, nc ,depth + 1);
        }
    }
}