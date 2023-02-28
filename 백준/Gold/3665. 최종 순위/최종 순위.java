import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static final String rankingError = "IMPOSSIBLE";
    static boolean[][] edges;
    static int[] indegree;
    static int[] original;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        /* 위상 정렬 구현
            - boolean[][] edges : 그래프의 관계를 표현하는 2차원 인접 행렬
            - int[] indegree : 해당 노드를 가리키는 간선의 수를 담은 배열
            - Queue<Integer> queue : indegree 값이 0이 된 노드를 담는 큐
            - Queue<Integer> result : queue 에서 poll 되어 결과로 출력하는 값을 담는 큐 -> 생략 가능 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            indegree = new int[N+1];
            original = new int[N];
            edges = new boolean[N+1][N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) original[i] = Integer.parseInt(st.nextToken());
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    edges[original[i]][original[j]] = true;
                    indegree[original[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());
            while(M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(edges[a][b]) {
                    edges[a][b] = false;
                    edges[b][a] = true;
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    edges[a][b] = true;
                    edges[b][a] = false;
                    indegree[a]--;
                    indegree[b]++;
                }
            }
            sort();
        }
        System.out.println(sb);
    }
    private static void sort() {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for(int i=1; i<=N; i++) {
                if(edges[cur][i]) {
                    indegree[i]--;
                    if(indegree[i] == 0) q.add(i);
                }
            }
        }
        findRank(result);
    }
    private static void findRank(List<Integer> list) {
        if(list.size() == N) {
            for(int i=0; i<N; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        } else sb.append(rankingError).append("\n");
    }
}