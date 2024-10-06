import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] graph;
    static long[] amount;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new ArrayList[N];
        amount = new long[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        long lcm = 1L;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, p, q});
            graph[b].add(new int[]{a, q, p});

            lcm *= (p * q) / gcd(p, q);
        }

        amount[0] = lcm; // 첫번째 재료의 값을 최소공배수의 곱으로 지정
        dfs(0);

        long gcdAmount = amount[0];
        for (int i = 1; i < N; i++) {
            gcdAmount = gcd(gcdAmount, amount[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(amount[i] / gcdAmount).append(" ");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int[] next : graph[node]) {
            int b = next[0];
            int p = next[1];
            int q = next[2];

            if (!visited[b]) {
                amount[b] = amount[node] * q / p;
                dfs(b);
            }
        }
    }
}
