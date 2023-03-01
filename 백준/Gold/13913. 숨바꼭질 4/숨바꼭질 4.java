import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, INF = 100_001;
    static int[] visited, path;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[INF];
        path = new int[INF];
        Arrays.fill(visited, INF);
    }
    private static void bfs() {
        if(N == K) {
            sb.append(0).append("\n").append(N);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.idx * 2 < INF) { // *2 순간 이동이 가능한 경우
                if(visited[cur.idx*2] == INF || visited[cur.idx * 2] > cur.cnt) {
                    visited[cur.idx * 2] = cur.cnt + 1;
                    path[cur.idx*2] = cur.idx;
                    q.add(new Node(cur.idx * 2, cur.cnt + 1));
                }
            }
            if(cur.idx - 1 >= 0) { // -1 이동이 가능한 경우
                if(visited[cur.idx-1] == INF || visited[cur.idx - 1] > cur.cnt + 1) {
                    visited[cur.idx-1] = cur.cnt + 1;
                    path[cur.idx-1] = cur.idx;
                    q.add(new Node(cur.idx - 1, cur.cnt + 1));
                }
            }
            if(cur.idx + 1 < INF) { // +1 이동이 가능한 경우
                if(visited[cur.idx+1] == INF || visited[cur.idx + 1] > cur.cnt + 1) {
                    visited[cur.idx+1] = cur.cnt + 1;
                    path[cur.idx+1] = cur.idx;
                    q.add(new Node(cur.idx + 1, cur.cnt + 1));
                }
            }
        }
        sb.append(visited[K]).append("\n");
        printPath();
    }
    private static void printPath() {
        Stack<Integer> stack = new Stack<>();
        while(true) {
            stack.push(K);
            K = path[K];
            if(N == K) {
                stack.push(K);
                break;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
    }
    private static class Node {
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}