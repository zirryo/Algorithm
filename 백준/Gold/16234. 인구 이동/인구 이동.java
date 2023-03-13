import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R; // (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
    static int result = 0;
    static boolean isMoved;
    static int[][] population;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        population = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(result);
    }
    private static void solve() {
        do {
            Queue<Pos> q = new LinkedList<>();
            visited = new boolean[N][N];
            isMoved = false;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
            if(isMoved) result++;
        } while (isMoved); // 한 연합이라도 인구 이동이 생긴다면 반복문 지속
    }
    private static void bfs(int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        ArrayList<Pos> list = new ArrayList<>(); // 인구 이동이 필요한 국가 리스트
        q.offer(new Pos(r, c));
        list.add(new Pos(r, c));

        int sum = population[r][c]; // 국경선이 열린 국가들의 인구총합

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;

                int diff = Math.abs(population[nr][nc] - population[cur.r][cur.c]);
                if(diff < L || diff > R) continue;

                q.offer(new Pos(nr, nc));
                list.add(new Pos(nr, nc));
                sum += population[nr][nc];
                visited[nr][nc] = true;
            }
        }

        if(list.size() > 1) {
            changePop(sum, list); // 인구 이동 실행
            isMoved = true;
        }
    }
    private static void changePop(int sum, ArrayList<Pos> list) {
        int avg = sum / list.size();
        for(Pos pos : list) {
            population[pos.r][pos.c] = avg;
        }
    }
    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}