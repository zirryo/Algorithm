import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[][] grid = new int[N][N];
        fillGrid(grid, N);

        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void fillGrid(int[][] grid, int N) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0;
        int value = N * N;
        int step = -2;

        for (int i = 0; i < N * N; i++) {
            grid[x][y] = value;

            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || grid[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dir[d][0];
                ny = y + dir[d][1];
            }

            x = nx; y = ny;

            if ((N % 2 == 1 && value == 1) || (N % 2 == 0 && value == 2)) {
                if (N % 2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                step = 2;
            } else {
                value += step;
            }


        }
    }

}
