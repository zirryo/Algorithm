import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max = 0, cnt = 0;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = -1;
                } else if(map[i][j] == 1) {
                    cnt++;
                    int area = 0;
                    map[i][j] = -1;
                    q = new LinkedList<>();
                    q.add(new Node(i, j));

                    while (!q.isEmpty()) {
                        area++;
                        Node cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = cur.r + dr[k];
                            int nc = cur.c + dc[k];

                            if (isValid(nr, nc) && map[nr][nc] == 1) {
                                q.add(new Node(nr, nc));
                                map[nr][nc] = -1;
                            }
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        System.out.println(cnt + "\n" + max);

    }
    private static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}