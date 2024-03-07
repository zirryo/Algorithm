import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] lenArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            lenArr[cur.barnNum] = cur.dist;

            for (int next : graph[cur.barnNum]) {
                if (visited[next]) continue;
                q.add(new Node(next, cur.dist + 1));
                visited[next] = true;

            }
        }

        int target = 0;
        int maxDist = 0;
        int maxCnt = 0;

        for (int i = 2; i <= N; i++) {
            if (maxDist < lenArr[i]) {
                target = i;
                maxDist = lenArr[i];
                maxCnt = 1;
            } else if (maxDist == lenArr[i]) {
                maxCnt++;
            }
        }

        System.out.println(String.format("%d %d %d", target, maxDist, maxCnt));
    }
}
class Node {
    int barnNum;
    int dist;

    public Node(int barnNum, int dist) {
        this.barnNum = barnNum;
        this.dist = dist;
    }
}