import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, LIS = 1;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();

        dp[0] = 1;
        for (int i=1; i<N; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }

        int val = LIS;
        sb.append(LIS).append("\n");
        Stack<Integer> stack = new Stack<>();

        for (int i=N-1; i>=0; i--) {
            if(val == dp[i]) {
                stack.push(arr[i]);
                val--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }
}