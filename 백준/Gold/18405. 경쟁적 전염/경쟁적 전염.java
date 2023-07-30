import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, S;
    static int[][] board;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Virus target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        target = new Virus(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1, -1);

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Virus> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] != 0) {
                    pq.add(new Virus(i, j, board[i][j]));

                }
            }
        }
        while (S-- > 0) {
            Queue<Virus> q = new LinkedList<>();
            while (!pq.isEmpty()) {
                Virus cur = pq.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (nr < 0 || nr >=N || nc < 0 || nc >= N || board[nr][nc] != 0) continue;
                    q.add(new Virus(nr, nc, cur.num));
                    board[nr][nc] = cur.num;
                }
            }
            if (q.isEmpty()) break;
            while (!q.isEmpty()) {
                pq.add(q.poll());
            }
        }
        return board[target.r][target.c];
    }
    private static class Virus implements Comparable<Virus> {
        int r;
        int c;
        int num;

        public Virus(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Virus virus) {
            return this.num - virus.num;
        }
    }
}