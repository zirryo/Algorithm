import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, LIS;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        LIS = 0;

        for(int i=0; i<N; i++) {
            int val = binarySearch(0, LIS, arr[i]);

            if(val == -1) {
                dp[LIS] = arr[i];
                LIS++;
            } else {
                dp[val] = arr[i];
            }
        }
        System.out.println(LIS);
    }

    private static int binarySearch(int l, int r, int target) {
        int temp = 0;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(target <= dp[mid]) {
                temp = mid;
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }

        if(l > LIS) return -1; // dp에 없는 큰 수일 때
        else return temp;
    }

}