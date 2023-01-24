import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int connect = 1;
        dp[1] = arr[1];

        for(int i=2; i<=N; i++) {
            if(arr[i] > dp[connect]) {
                connect++;
                dp[connect] = arr[i];
            } else {
                for(int j = 1; j <= connect; j++) {
                    if(arr[i] <= dp[j]) {
                        dp[j] = arr[i];
                        break;
                    }
                }
            }
        }
        System.out.println(connect);
    }
}