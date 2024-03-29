import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 200 * 1000;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a][b] = t;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] friends = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        int[] maxCost = new int[n+1]; // 도시별 최대 왕복 시간
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < K; j++) {
                maxCost[i] = Math.max(maxCost[i], graph[friends[j]][i] + graph[i][friends[j]]);
            }
        }

        List<Integer> cities = new ArrayList<>();
        int min = INF * 2;

        for (int i = 1; i <= n; i++) {
            if (maxCost[i] < min) {
                min = maxCost[i];
                cities.clear();
                cities.add(i);
            } else if (maxCost[i] == min) {
                cities.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : cities) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}