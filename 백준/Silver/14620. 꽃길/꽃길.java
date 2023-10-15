import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, totalCost = 200 * 10 * 10;
    static int[][] price;
    static ArrayList<Seed> seedList;
    static int[] selected = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seedList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        M = (N - 2) * (N - 2);
        StringTokenizer st;
        price = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                seedList.add(new Seed(i, j));
            }
        }
        selectSeedSpot(0, 0);
        System.out.println(totalCost);
    }
    private static void selectSeedSpot(int depth, int idx) {
        if (depth == 3) {
            bloom();
            return;
        }

        for (int i = idx; i < M; i++) {
            selected[depth] = i;
            selectSeedSpot(depth + 1, idx + 1);
        }
    }
    private static void bloom() {
        boolean flag = true;
        int cost = 0;
        int[] dr = {0, 0, 1, 0, -1};
        int[] dc = {0, 1, 0, -1, 0};
        boolean[][] occupied = new boolean[N][N];
        for (int i = 0; i < 3; i++) {
            Seed cur = seedList.get(selected[i]);
            for (int j = 0; j < 5; j++) {
                int nr = cur.r + dr[j];
                int nc = cur.c + dc[j];
                if (occupied[nr][nc]) {
                    return;
                } else {
                    occupied[nr][nc] = true;
                    cost += price[nr][nc];
                }
            }
        }
        totalCost = Math.min(totalCost, cost);
    }
}
class Seed {
    int r;
    int c;

    public Seed(int r, int c) {
        this.r = r;
        this.c = c;
    }
}