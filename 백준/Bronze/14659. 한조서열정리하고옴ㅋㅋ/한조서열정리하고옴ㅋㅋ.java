import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] h = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[] nextGreater = new int[N];
        Arrays.fill(nextGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && h[stack.peek()] < h[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt;
            if (nextGreater[i] == -1) {
                cnt = N - i - 1;
            } else {
                cnt = nextGreater[i] - i - 1;
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
