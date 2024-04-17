import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] cycle;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (list[i].size() == 1) continue; // 순환선은 반드시 연결역이 2개 이상
            cycle = new boolean[N + 1];
            if(isCycled(i, i, i)) break;
        }

        for (int i = 1; i <= N; i++) {
            if (cycle[i] && list[i].size() >= 3) getShortestDist(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
    private static boolean isCycled(int start, int pre, int cur) {
        cycle[cur] = true;
        for (int next : list[cur]) {
            if (!cycle[next]) {
                if (isCycled(start, cur, next)) return true;
            } else if (pre != next && next == start) return true;
        }
        cycle[cur] = false;
        return false;
    }
    private static void getShortestDist(int node) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(new int[]{node, 0});
        visited[node] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int next : list[cur[0]]) {
                if (cycle[next] || visited[next]) continue;
                visited[next] = true;
                result[next] = cur[1] + 1;
                q.add(new int[]{next, cur[1] + 1});
            }
        }
    }
}