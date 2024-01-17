import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long DIV = 1_000_000_000;
        long[] dp = new long[1000001];
        dp[2] = 1;
        dp[3] = 2;
        for (int i=4; i<=N; i++) {
            dp[i] = (i - 1) * (dp[i-1] + dp[i-2]) % DIV;
        }
        System.out.println(dp[N]);
    }
}

/* 완전순열 (교란순열)
 - 사람들이 각각 자신의 모자를 벗었다가 아무 모자나 다시 쓰는데, 모든 사람이 자기 것이 아닌 모자를 쓰는 순열
 - 이 개념을 처음 제시한 프랑스의 수학자 피에르 레몽 드몽모르(Pierre Raymond de Montmort)의 이름을 따 드몽모르 수라고도 함.
 - 점화식 Dn = (n - 1) * (Dn-1 + Dn-2)
 - D1 = 0, D2 = 1, D3 = 2, D4 = 9 ,,,,,,
 */