import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static int[] arr;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        sum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        for (int i = 2; i < N; i++) {
            // 1 - 벌통의 위치 : N, 벌의 위치 : 1, i
            result = Math.max(result, sum[N] - arr[1] - arr[i] + sum[N] - sum[i]);
            // 2 - 벌통의 위치 : 1, 벌의 위치 : i, N
            result = Math.max(result, sum[N-1] - arr[i] + sum[i-1]);
            // 3 - 벌통의 위치 : i, 벌의 위치 : 1, N
            result = Math.max(result, sum[i] - arr[1] + sum[N-1] - sum[i-1]);
        }
        System.out.println(result);
    }
}