import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(N-- >0) {
            int k = Integer.parseInt(br.readLine());
            sb.append(waveSequence(k) + "\n");
        }
        System.out.println(sb);

    }

    static long waveSequence(int k) {
        if(dp[k] != 0) return dp[k];

        if(k<=3) return dp[k] = 1;
        return dp[k] = waveSequence(k-2) + waveSequence(k-3);
    }
}