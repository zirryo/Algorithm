import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int len = 0;
        char[][] arr = new char[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j-1);
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (arr[i][j] == '0') continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                if (len <dp[i][j]) len = dp[i][j];
            }
        }
        
        System.out.println(len * len);
    }
}