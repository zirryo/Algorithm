import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int INF = 100001;
    static int N, K;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[INF];
        Arrays.fill(visited, INF);

        bfs();
        System.out.println(visited[K]);
    }
    static void bfs() {
        if(N == K) {
            visited[K] = 0;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.idx * 2 < INF) { // *2 순간 이동이 가능한 경우
                if(visited[cur.idx*2] == INF || visited[cur.idx * 2] > cur.cnt) {
                    visited[cur.idx * 2] = cur.cnt;
                    q.add(new Node(cur.idx * 2, cur.cnt));
                }
            }
            if(cur.idx - 1 >= 0) { // -1 이동이 가능한 경우
                if(visited[cur.idx-1] == INF || visited[cur.idx - 1] > cur.cnt + 1) {
                    visited[cur.idx-1] = cur.cnt + 1;
                    q.add(new Node(cur.idx - 1, cur.cnt + 1));
                }
            }
            if(cur.idx + 1 <INF) { // +1 이동이 가능한 경우
                if(visited[cur.idx+1] == INF || visited[cur.idx + 1] > cur.cnt + 1) {
                    visited[cur.idx+1] = cur.cnt + 1;
                    q.add(new Node(cur.idx + 1, cur.cnt + 1));
                }
            }
        }
    }

}
class Node {
    int idx;
    int cnt;

    public Node(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}