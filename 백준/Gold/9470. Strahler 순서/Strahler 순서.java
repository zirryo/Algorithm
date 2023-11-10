import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, M, P;
    static int[] indegree;
    static ArrayList<Integer>[] flows;
    static Flow[] flowInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            indegree = new int[M+1];
            flows = new ArrayList[M+1];
            flowInfo = new Flow[M+1];
            for (int i = 1; i <= M; i++) {
                flows[i] = new ArrayList<>();
                flowInfo[i] = new Flow(i, 0, 0);
            }
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                indegree[b]++;
                flows[a].add(b);
            }

            sb.append(K + " " + topologySort() + "\n");
        }
        System.out.println(sb);
    }
    private static int topologySort () {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (indegree[i] == 0) q.add(new int[]{i, 1}); // 노드 번호, 개수
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == M) break;
            for (int next : flows[cur[0]]) {
                if (flowInfo[next].strahler < cur[1]) {
                    flowInfo[next].strahler = cur[1];
                    flowInfo[next].cnt = 1;
                } else if (flowInfo[next].strahler == cur[1]) {
                    flowInfo[next].cnt++;
                }

                indegree[next]--;
                if (indegree[next] == 0) {
                    if (flowInfo[next].cnt > 1) flowInfo[next].strahler++;
                    q.add(new int[]{next, flowInfo[next].strahler});
                }
            }
        }

        return flowInfo[M].strahler;
    }
}
class Flow {
    int num;
    int strahler;
    int cnt;

    public Flow(int num, int strahler, int cnt) {
        this.num = num;
        this.strahler = strahler;
        this.cnt = cnt;
    }
}