import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> list;
    static int[] indegree;
    static int[] cost;
    /* 위상 정렬 구현
    - List<List<Integer>> list : 그래프의 관계를 표현하는 2차원 인접 리스트
    - int[] indegree : 해당 노드를 가리키는 간선의 수를 담은 배열
    - Queue<Integer> queue : indegree 값이 0이 된 노드를 담는 큐
    - Queue<Integer> result : queue 에서 poll 되어 결과로 출력하는 값을 담는 큐 -> 생략 가능
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        cost = new int[N+1];
        list = new ArrayList<>();
        StringTokenizer st;

        for (int i=0; i<=N; i++) list.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int subTasks = Integer.parseInt(st.nextToken());
            indegree[i] = subTasks;
            for (int j = 0; j < subTasks; j++) {
                int k = Integer.parseInt(st.nextToken());
                list.get(k).add(i);
            }
        }
        System.out.println(solve());
    }
    private static int solve() {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        for (int i=1; i<=N; i++) {
            result[i] = cost[i];
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list.get(cur)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[cur] + cost[next]);
                if (indegree[next] == 0) q.add(next);
            }
        }

        int totalCost = 0;
        for (int i = 1; i <= N; i++) {
            totalCost = Math.max(totalCost, result[i]);
        }
        return totalCost;
    }
}