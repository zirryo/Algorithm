import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }

        int max = 0;
        int cnt = 0;
        for (int i = M; i <= N; i++) {
            if (sum[i] - sum[i-M] > max) {
                max = sum[i] - sum[i-M];
                cnt = 1;
            } else if (sum[i] - sum[i-M] == max) {
                cnt++;
            }
        }

        if (max == 0) System.out.println("SAD");
        else System.out.println(max + "\n" + cnt);
    }
}