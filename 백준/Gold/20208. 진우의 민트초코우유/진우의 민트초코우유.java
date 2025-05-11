import java.util.*;

public class Main {
    static int N, M, H, maxMilk = 0;
    static int[][] map;
    static boolean[] visited;
    static List<int[]> milks = new ArrayList<>();
    static int homeX, homeY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    homeX = i;
                    homeY = j;
                } else if (map[i][j] == 2) {
                    milks.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[milks.size()];
        dfs(homeX, homeY, M, 0);

        System.out.println(maxMilk);
    }

    static void dfs(int x, int y, int hp, int count) {
        if (getDist(x, y, homeX, homeY) <= hp) {
            maxMilk = Math.max(maxMilk, count);
        }

        for (int i = 0; i < milks.size(); i++) {
            if (visited[i]) continue;
            int[] milk = milks.get(i);
            int dist = getDist(x, y, milk[0], milk[1]);
            if (dist <= hp) {
                visited[i] = true;
                dfs(milk[0], milk[1], hp - dist + H, count + 1);
                visited[i] = false;
            }
        }
    }

    static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
