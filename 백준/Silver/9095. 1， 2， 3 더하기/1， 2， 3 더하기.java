import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(finddp(n)).append("\n");
        }
        System.out.println(sb);
    }
    public static int finddp(int n) {
        if(n<=3 || dp[n] != 0) return dp[n];
        return dp[n] = finddp(n-1) + finddp(n-2) + finddp(n-3);
    }

}