import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건 수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] weight = new int[N+1];
        int[] price = new int[N+1];
        int[] dp = new int[K+1]; // 각 무게(인덱스) 마다 물건 가치의 최대합을 담는 배열

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=K; j-weight[i]>=0; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
            }
        }
        System.out.println(dp[K]);
    }
}
