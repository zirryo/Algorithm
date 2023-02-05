import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int N, M;
    static long K;
    static final int INF = 1_000_000_001;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        dp = new int[101][101];

        int totalCase = count(N, M);

        if(K > totalCase) {
            System.out.println(-1);
            System.exit(0);
        }

        makeString(N, M, K);
        System.out.println(sb);
    }

    private static int count(int n, int r) {
        if(n==0 || r==0) return dp[n][r] = 1;
        if(dp[n][r] > 0) return dp[n][r];
        return dp[n][r] = Math.min(count(n - 1, r) + count(n, r-1), INF);
    }

    private static void makeString(int a, int z, long pos) {
        if(a == 0) {
            sb.append("z".repeat(z));
            return;
        }
        if(z == 0) {
            sb.append("a".repeat(a));
            return;
        }

        int temp = count(a-1, z);

        if(temp >= pos) {
            sb.append("a");
            makeString(a-1, z, pos);
        } else {
            sb.append("z");
            makeString(a, z-1, pos-temp);
        }
    }
}