import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] visitOrder = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitOrder[i] = Integer.parseInt(st.nextToken());
        }

        if (visitOrder[0] != 1) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int idx = 1;
        boolean result = true;

        Outer:
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Set<Integer> curDepth = new HashSet<>();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    curDepth.add(next);
                    visited[next] = true;
                }
            }

            while (idx < N && !curDepth.isEmpty()) {
                int nextOrder = visitOrder[idx];
                if (curDepth.contains(nextOrder)) {
                    idx++;
                    curDepth.remove(nextOrder);
                    queue.add(nextOrder);
                } else {
                    result = false;
                    break Outer;
                }
            }
        }

        if (result) System.out.println("1");
        else System.out.println("0");

    }
}