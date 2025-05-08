import java.io.*;
import java.util.*;

public class Main {
    static final int N = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 1; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < 12; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < N; i++) {
            if (graph[i].size() == 3) {
                int deg1 = 0, deg2 = 0, deg3 = 0;
                for (int neighbor : graph[i]) {
                    int d = graph[neighbor].size();
                    if (d == 1) deg1++;
                    else if (d == 2) deg2++;
                    else if (d == 3) deg3++;
                }

                if (deg1 == 1 && deg2 == 1 && deg3 == 1) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
