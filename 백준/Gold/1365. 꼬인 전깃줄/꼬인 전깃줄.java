import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, LIS = 0;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int idx = binarySearch(0, LIS, arr[i]);

            if (idx == -1) {
                dp[LIS] = arr[i];
                LIS++;
            } else {
                dp[idx] = arr[i];
            }
        }
        System.out.println(N - LIS);
    }
    private static int binarySearch(int l, int r, int target) {
        int idx = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            if (target <= dp[m]) {
                idx = m;
                r = m - 1;
            } else l = m + 1;
        }

        if (l > LIS) return -1;
        else return idx;
    }
}