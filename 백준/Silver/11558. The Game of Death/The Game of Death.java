import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] target = new int[N+1];
            boolean[] visited = new boolean[N+1];
            for (int i = 1; i <= N; i++) {
                target[i] = Integer.parseInt(br.readLine());
            }

            int result = 0;
            int cur = 1;

            while (true) {
                if (visited[cur]) {
                    result = 0;
                    break;
                } else {
                    visited[cur] = true;
                    int next = target[cur];
                    result++;
                    cur = next;

                    if (cur == N) {
                        break;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
