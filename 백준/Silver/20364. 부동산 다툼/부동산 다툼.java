import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(getGroundNum(x)).append("\n");
        }

        System.out.println(sb);
    }
    private static int getGroundNum(int x) {
        int ans = 0;
        int cur = x;

        while (cur > 0) {
            if (visited[cur]) {
                ans = cur;
            }
            cur /= 2;
        }

        if (ans == 0) visited[x] = true;
        return ans;
    }
}