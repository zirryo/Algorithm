import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        Node junan = new Node(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1, 0);
        Node choco = new Node(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1, 0);
        pq.add(junan);
        visited[junan.r][junan.c] = true;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int friends = cur.cnt;

            if (cur.r == choco.r && cur.c == choco.c) {
                // 가장 처음 목적지에 도달한 경우가 최솟값
                result = friends;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= N || nc >= M || nr < 0 || nc < 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if (map[nr][nc] == '0') {
                    pq.add(new Node(nr, nc, cur.cnt));
                } else {
                    pq.add(new Node(nr, nc, cur.cnt + 1));
                }
            }
        }


        System.out.println(result);
    }
    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            return this.cnt - n.cnt;
        }
    }
}