import java.util.*;

public class Main {
    static int N, M;
    static int[][] matrix;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 0~9 중 3개 선택 (중복 허용, 오름차순만)
        for (int a = 0; a <= 9; a++) {
            for (int b = a; b <= 9; b++) {
                for (int c = b; c <= 9; c++) {
                    Set<Integer> trinity = new HashSet<>();
                    trinity.add(a);
                    trinity.add(b);
                    trinity.add(c);

                    if (canEscape(trinity)) {
                        System.out.println(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }

        System.out.println("-1 -1 -1");
    }

    static boolean canEscape(Set<Integer> trinity) {
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int j = 0; j < N; j++) {
            if (trinity.contains(matrix[0][j])) {
                queue.add(new int[]{0, j});
                visited[0][j] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];
            if (y == M - 1) return true;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (0 <= ny && ny < M && 0 <= nx && nx < N) {
                    if (!visited[ny][nx] && trinity.contains(matrix[ny][nx])) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

        return false;
    }
}
