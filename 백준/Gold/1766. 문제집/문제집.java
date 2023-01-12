import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        /*
        위상 정렬 구현
            - List<List<Integer>> list : 그래프의 관계를 표현하는 2차원 인접 리스트
            - int[] indegree : 해당 노드를 가리키는 간선의 수를 담은 배열
            - Queue<Integer> queue : indegree 값이 0이 된 노드를 담는 큐
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            indegree[B]++;
        }

        sort(indegree, list);
        System.out.println(sb);
    }

    private static void sort(int[] indegree, List<List<Integer>> list) {
        /*
        1. indegree = 0 인 값을 큐에 넣음
        2. 큐에서 poll 한 후 해당 값에 연결된 간선을 하나씩 지움 (indegree 값 줄임)
        3. 간선이 지워지면서 indegree 값이 0이 된 정점을 또 큐에 삽입
        4. 큐가 비워질 때 까지 반복
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 쉬운 문제를 먼저 해결하기 위해 우선순위 큐 이용

        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");

            for(Integer next : list.get(temp)) {
                indegree[next]--;

                if(indegree[next] == 0) queue.add(next);
            }
        }
    }
}