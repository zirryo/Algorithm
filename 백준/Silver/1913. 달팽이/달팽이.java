import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int x = n / 2, y = n / 2;
        int num = 1, step = 1;
        board[x][y] = num;

        while (num < n * n) {
            for (int i = 0; i < step && num < n * n; i++) board[--x][y] = ++num;
            for (int i = 0; i < step && num < n * n; i++) board[x][++y] = ++num;
            step++;
            for (int i = 0; i < step && num < n * n; i++) board[++x][y] = ++num;
            for (int i = 0; i < step && num < n * n; i++) board[x][--y] = ++num;
            step++;
        }

        StringBuilder sb = new StringBuilder();
        int targetX = -1, targetY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]).append(" ");
                if (board[i][j] == target) {
                    targetX = i + 1;
                    targetY = j + 1;
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.println(targetX + " " + targetY);
    }
}
