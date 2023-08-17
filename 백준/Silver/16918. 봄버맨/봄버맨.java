import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        boolean[][] bomb = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'O') {
                    bomb[i][j] = true;
                    q.add(new Node(i, j));
                }
            }
        }

        if (N % 2 == 0) {
            for (int i = 0; i< R; i++) {
                Arrays.fill(bomb[i], true);
            }
        } else if (N % 4 == 3){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (bomb[i][j]) bomb[i][j] = false;
                    else bomb[i][j] = true;
                }
            }
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if (nr >= R || nr < 0 || nc >= C || nc < 0 || !bomb[nr][nc]) continue;
                    bomb[nr][nc] = false;
                }
            }
        } else if (N % 4 == 1 && N != 1) {
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if (nr >= R || nr < 0 || nc >= C || nc < 0 || bomb[nr][nc]) continue;
                    bomb[nr][nc] = true;
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!bomb[i][j]) q.add(new Node(i, j));
                }
            }
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if (nr >= R || nr < 0 || nc >= C || nc < 0 || !bomb[nr][nc]) continue;
                    bomb[nr][nc] = false;
                }
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j]) sb.append("O");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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