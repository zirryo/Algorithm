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
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N-1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken()); // 증가하는 수열로 만들기 위해 역순으로 저장.
        }

        for (int i = 0; i < N; i++) {
            int k = binarySearch(0, LIS, arr[i]);

            if (k == -1) {
                dp[LIS++] = arr[i];
            } else {
                dp[k] = arr[i];
            }
        }

        System.out.println(N - LIS);
    }
    private static int binarySearch(int l, int r, int target) {
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (target <= dp[mid]) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (l > LIS) return -1; // dp 에 없는 큰 값인 경우 -1 리턴
        else return result;
    }
}