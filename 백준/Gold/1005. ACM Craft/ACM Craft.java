import java.io.*;
import java.util.*;

public class Main {
    static int N, W;
    static int[] indegree;
    static int[] delay;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            list = new ArrayList<>();
            list.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            delay = new int[N+1];
            indegree = new int[N+1];
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).add(y);
                indegree[y]++;
            }
            W = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(craft()) + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static int craft() {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        for (int i=1; i<=N; i++) {
            result[i] = delay[i];
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list.get(cur)) {
                indegree[next]--;
                result[next] = Math.max(result[cur] + delay[next], result[next]);
                if (indegree[next] == 0) {
                    if (next == W) break;
                    else q.add(next);
                }
            }
        }
        return result[W];
    }
}