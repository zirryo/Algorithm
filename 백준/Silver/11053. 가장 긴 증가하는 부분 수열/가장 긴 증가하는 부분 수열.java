import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N]; // 인덱스의 최대 부분 수열 길이
        int[] seq = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (seq[j] < seq[i] && dp[j] + 1  > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i=N-1; i>=0; i--) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max+1); // 비교대상 인덱스도 수열에 포함되므로 +1
    }
}
