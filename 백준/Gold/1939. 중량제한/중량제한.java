import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int to;
    int limit;

    public Node(int to, int limit) {
        this.to = to;
        this.limit = limit;
    }
}

public class Main {
    static int N, M, island1, island2;
    static int min, max = 0;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            max = Math.max(max, c);
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        island1 = Integer.parseInt(st.nextToken());
        island2 = Integer.parseInt(st.nextToken());

        while(min <= max) {
            int mid = (min + max) / 2;

            if(bfs(mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    private static boolean bfs(int weight) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];

        q.add(island1);
        isVisited[island1] = true;

        while(!q.isEmpty()) {
            int start = q.poll();
            if(start == island2) return true;

            for(Node n : list[start]) {
                int next = n.to;
                int limit = n.limit;

                if(!isVisited[next] && limit >= weight) {
                    isVisited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }

}