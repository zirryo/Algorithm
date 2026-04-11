import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] pathList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        pathList = new ArrayList[V + 1];
        int[] degree = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            pathList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pathList[u].add(v);
            pathList[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        // 조건1) 모든 지점이 하나로 연결되어 있어야 함
        visited = new boolean[V + 1];
        int visitedCount = dfs(1);

        if (visitedCount != V) {
            System.out.println("NO");
            return;
        }

        // 조건2) 홀수 차수 지점이 0개(회로) or 2개(경로)여야 함
        int oddCnt = 0;
        for (int i = 1; i <= V; i++) {
            if (degree[i] % 2 != 0) {
                oddCnt++;
            }
        }

        if (oddCnt == 0 || oddCnt == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static int dfs(int cur) {
        visited[cur] = true;
        int cnt = 1;
        for (int next : pathList[cur]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}

/* 오일러 경로 (Eulerian Path)
- 그래프의 모든 간선(Edge)을 정확히 한 번씩만 통과하는 경로, 한붓그리기

- 오일러 경로: 모든 간선을 한 번씩 지나고, 시작점 != 끝점
  - 모든 정점의 차수가 짝수

- 오일러 회로: 모든 간선을 한 번씩 지나고, 시작점 == 끝점
  - 차수가 홀수인 정점이 2개이며, 한 지점이 시작점 다른 지점이 끝점이 된다.
  - 들어오는 길이 있으면 나가는 길이 있어야 하므로, 시점과 좀점은 간선을 하나 더 필요로 한다.
 */