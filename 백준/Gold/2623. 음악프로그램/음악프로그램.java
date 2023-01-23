import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int singers = Integer.parseInt(st.nextToken());

            if(singers <= 1) continue;

            int pre = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());

                list.get(pre).add(k);
                indegree[k]++;
                pre = k;
            }
        }

        sort(list);

        if(isCycle()) System.out.println(0); // 정점간의 사이클이 존재할 경우 위상 정렬 불가
        else System.out.println(sb);
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
            }
        }

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            sb.append(temp).append("\n");

            for(Integer next : list.get(temp)) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }

    private static boolean isCycle() { // 큐가 비었을 때 모든 정점을 방문하지 않음 -> 사이클 존재
        for(int i=1; i<=N; i++) {
            if(!visited[i]) return true;
        }

        return false;
    }
}