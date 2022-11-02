import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 투 포인터 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken()); // 넘어온 날
        int K = Integer.parseInt(st.nextToken()); // 떡의 개수
        int[] dp = new int[30]; // A와 B에 곱해지는 계수가 피보나치

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<30; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int A = 1;
        int B;

        while(true) {
            if((K - dp[D-3]*A) % dp[D-2] == 0) {
                B = (K - dp[D-3]*A) / dp[D-2];
                break;
            }
            A++;
        }
        System.out.println(A);
        System.out.println(B);
    }
}