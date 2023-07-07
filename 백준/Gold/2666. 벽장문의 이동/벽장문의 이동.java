import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[] targetArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int open1 = Integer.parseInt(st.nextToken());
        int open2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        targetArr = new int[m];
        result = n * m;

        for (int i = 0; i < m; i++) {
            targetArr[i] = Integer.parseInt(br.readLine());
        }

        dfs(open1, open2, 0, 0);
        System.out.println(result);
    }
    private static void dfs(int o1, int o2, int depth, int move) {
        if (move > result) return;
        if (depth == m) {
            result = Math.min(result, move);
            return;
        }

        dfs(o1, targetArr[depth], depth+1, move + Math.abs(o2 - targetArr[depth]));
        dfs(o2, targetArr[depth], depth+1, move + Math.abs(o1 - targetArr[depth]));
    }
}