import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] graph = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        boolean possible = true;
        int cnt = 0;

        for (int i = N; i > 1; i--) {
            if (graph[i].size() - cnt == 0) {
                sb.append("N");
            } else if (graph[i].size() - cnt == i - 1) {
                sb.append("E");
                cnt++;
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            String ans = sb.reverse().toString();
            System.out.println(ans);
        } else {
            System.out.println("-1");
        }
    }
}
