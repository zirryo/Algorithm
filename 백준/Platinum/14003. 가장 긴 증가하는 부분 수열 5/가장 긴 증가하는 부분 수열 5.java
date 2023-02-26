import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, LIS = 0;
    static int[] arr, dp, idx;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();

        for(int i=0; i<N; i++) {
            int val = binarySearch(0, LIS, arr[i]);

            if(val == -1) {
                dp[LIS] = arr[i];
                idx[i] = LIS;
                LIS++;
            } else {
                dp[val] = arr[i];
                idx[i] = val;
            }
        }

        int val = LIS-1;
        sb.append(LIS).append("\n");
        Stack<Integer> stack = new Stack<>();

        for (int i=N-1; i>=0; i--) {
            if(val == idx[i]) {
                stack.push(arr[i]);
                val--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        idx = new int[N];
        Arrays.fill(dp, -1_000_000_001);
        Arrays.fill(idx, -1);
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
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