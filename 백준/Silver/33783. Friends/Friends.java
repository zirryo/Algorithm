import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = safeReadLine(br);
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int edgesRead = 0;
        while (edgesRead < m) {
            line = safeReadLine(br);
            if (line == null) break;
            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            int u = Integer.parseInt(st.nextToken());
            if (!st.hasMoreTokens()) continue;
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
            edgesRead++;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int next : graph[u]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }

    // 빈 줄을 건너뛰는 안전한 입력 처리
    private static String safeReadLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) return line;
        }
        return null;
    }
}
