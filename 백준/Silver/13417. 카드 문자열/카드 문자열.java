import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            Deque<Character> dq = new ArrayDeque<>();
            for (int j = 0; j < 2 * N; j += 2) {
                if (dq.isEmpty() || dq.peekFirst() >= arr[j]) {
                    dq.addFirst(arr[j]);
                } else {
                    dq.addLast(arr[j]);
                }
            }

            for (char c : dq) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
