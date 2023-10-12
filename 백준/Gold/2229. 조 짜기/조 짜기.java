import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            int max = -1;
            int min = 10000;

            for (int j = i; j > 0; j--) {
                max = Math.max(max, score[j]);
                min = Math.min(min, score[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }
        System.out.println(dp[N]);
    }
}