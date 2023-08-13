import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        int min = 100001;
        boolean[] visited = new boolean[100001];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.pos] = true;

            if (cur.pos == K) {
                if (min == cur.cnt) {
                    result++;
                } else if (min > cur.cnt){
                    min = cur.cnt;
                    result = 1;
                }
            }

            if (cur.pos + 1 < 100001 && !visited[cur.pos + 1]) {
                q.add(new Node(cur.pos + 1, cur.cnt + 1));
            }
            if (cur.pos - 1 >= 0 && !visited[cur.pos - 1]) {
                q.add(new Node(cur.pos - 1, cur.cnt + 1));
            }
            if (cur.pos * 2 < 100001 && !visited[cur.pos * 2]) {
                q.add(new Node(cur.pos * 2, cur.cnt + 1));
            }
        }

        System.out.println(min + "\n" + result);
    }
}
class Node {
    int pos;
    int cnt;

    public Node(int pos, int cnt) {
        this.pos = pos;
        this.cnt = cnt;
    }
}