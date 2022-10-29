import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int[] ways = new int[K+1]; // 0~K 원을 만드는 방법의 수를 담는 배열

        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        ways[0] = 1; // 0원을 만드는 방법의 수 == 1

        for(int i=0; i<N; i++) {
            for(int j=1; j<=K; j++) {
                if(j>=coins[i]) {
                    ways[j] = ways[j] + ways[j - coins[i]];
                }
            }
        }
        System.out.println(ways[K]);
    }
}