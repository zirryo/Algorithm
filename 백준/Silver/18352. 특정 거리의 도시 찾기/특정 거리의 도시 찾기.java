import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] roads = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        ArrayList<Integer> results = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roads[a].add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        visited[X] = true;

        while (K-- > 0) {
            int size = q.size();

            while (size-- > 0) {
                int cur = q.poll();
                for (int next : roads[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        while (!q.isEmpty()) {
            results.add(q.poll());
        }

        if (results.isEmpty()) sb.append(-1);
        else {
            Collections.sort(results);
            for (int result : results) {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}