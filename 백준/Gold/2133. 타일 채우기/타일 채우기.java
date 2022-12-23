import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N%2 != 0) {
            System.out.println(0);
            System.exit(0);
        }

        int[] dp = new int[31];

        dp[0] = 1; // N이 2씩 늘어날 때마다 예외케이스가 2개씩 생김. 인덱스 0의 값을 2로 두어 식을 단순하게 만듦.
        dp[2] = 3;

        // 점화식 : dp[n] = dp[n-2]*3 + dp[n-4]*2 + dp[n-6]*2 + ... + dp[0]*2
        for(int i=4; i<=N; i+=2) {
            dp[i] = dp[i-2] * 3;

            for(int j=0; j<i-2; j+=2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }

}