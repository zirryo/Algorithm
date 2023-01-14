import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] indegree;
    static int[] dp;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        /*
        위상 정렬 구현
            - List<List<Integer>> list : 그래프의 관계를 표현하는 2차원 인접 리스트
            - int[] indegree : 해당 노드를 가리키는 간선의 수를 담은 배열
            - Queue<Integer> queue : indegree 값이 0이 된 노드를 담는 큐
            - Queue<Integer> result : queue 에서 poll 되어 결과로 출력하는 값을 담는 큐 -> 생략 가능
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<List<Integer>> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        indegree = new int[N+1];
        dp = new int[N+1];
        cost = new int[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                if(k == -1) break;

                list.get(k).add(i);
                indegree[i]++;
            }
        }

        sort(list);

        for(int i=1; i<=N; i++) sb.append(dp[i]).append("\n");
        System.out.println(sb);
    }

    private static void sort(List<List<Integer>> list) {
        /*
        1. indegree = 0 인 값을 큐에 넣음
        2. 큐에서 poll 한 후 해당 값에 연결된 간선을 하나씩 지움 (indegree 값 줄임)
        3. 간선이 지워지면서 indegree 값이 0이 된 정점을 또 큐에 삽입
        4. 큐가 비워질 때 까지 반복
         */
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                dp[i] = cost[i];
            }
        }

        while(!queue.isEmpty()) {
            int temp = queue.poll();


            for(Integer next : list.get(temp)) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[temp] + cost[next]);

                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}