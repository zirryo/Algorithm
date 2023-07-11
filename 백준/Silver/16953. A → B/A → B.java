import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long n, m;
    static long result = 1000000001L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        dfs(n, 1L);

        if (result == 1000000001L) System.out.println(-1);
        else System.out.println(result);

    }
    static void dfs(long x, long cnt) {
        if (x > m) return;
        if (x == m) {
            result = Math.min(result, cnt);
        }

        dfs(x * 2, cnt + 1);
        dfs(x * 10 + 1, cnt + 1);
    }
}