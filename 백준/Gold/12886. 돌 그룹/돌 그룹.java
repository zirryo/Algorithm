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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean res = bfs(A, B, C);
        if(res) System.out.println(1);
        else System.out.println(0);
    }
    private static boolean bfs(int a, int b, int c) {
        if((a + b + c) % 3 != 0) return false; // 세 값을 더했을 때 3의 배수가 아니라면 아무리 연산해도 같아질 수 없음

        boolean[][] visited = new boolean[1501][1501]; // 세수의 합은 고정이므로 두 수가 정해지면 나머지 수도 알 수 있음.
        Queue<Stone> q = new LinkedList<>();
        q.add(new Stone(a, b, c));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Stone cur = q.poll();
            if(cur.a == cur.b && cur.b == cur.c) return true;
            if(cur.a != cur.b) {
                int x = cur.a < cur.b ? cur.a * 2 : cur.a - cur.b;
                int y = cur.a < cur.b ? cur.b - cur.a : cur.b * 2;
                if(!visited[x][y]) {
                    q.add(new Stone(x, y, cur.c));
                    visited[x][y] = true;
                }
            }
            if(cur.b != cur.c) {
                int x = cur.b < cur.c ? cur.b * 2 : cur.b - cur.c;
                int y = cur.b < cur.c ? cur.c - cur.b : cur.c * 2;
                if(!visited[x][y]) {
                    q.add(new Stone(cur.a, x, y));
                    visited[x][y] = true;
                }
            }
            if(cur.c != cur.a) {
                int x = cur.c < cur.a ? cur.c * 2 : cur.c - cur.a;
                int y = cur.c < cur.a ? cur.a - cur.c : cur.a * 2;
                if(!visited[x][y]) {
                    q.add(new Stone(y, cur.b, x));
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
    private static class Stone {
        int a;
        int b;
        int c;

        public Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}