import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
        }
        System.out.println(sb);
    }
    private static void bfs() {
        Queue<Status> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        int D, S, L, R;

        q.add(new Status(A, ""));
        visited[A] = true;

        while(!q.isEmpty()) {
            Status cur = q.poll();
            if(cur.val == B) {
                sb.append(cur.command).append("\n");
                break;
            }
            D = (cur.val * 2) % 10000;
            S = cur.val == 0 ? 9999 : cur.val - 1;
            L = cur.val / 1000 + (cur.val % 1000) * 10;
            R = cur.val / 10 + (cur.val % 10) * 1000;

            if(!visited[D]) {
                visited[D] = true;
                q.add(new Status(D, cur.command + "D"));
            }
            if(!visited[S]) {
                visited[S] = true;
                q.add(new Status(S, cur.command + "S"));
            }
            if(!visited[L]) {
                visited[L] = true;
                q.add(new Status(L, cur.command + "L"));
            }
            if(!visited[R]) {
                visited[R] = true;
                q.add(new Status(R, cur.command + "R"));
            }
        }
    }
    private static class Status {
        int val;
        String command;

        public Status(int val, String command) {
            this.val = val;
            this.command = command;
        }
    }
}