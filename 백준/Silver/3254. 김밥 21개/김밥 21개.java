import java.io.*;

public class Main {
    static int[][] board = new int[6][7];
    static int[] height = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 21; i++) {
            String[] input = br.readLine().split(" ");
            int sCol = Integer.parseInt(input[0]) - 1;
            int jCol = Integer.parseInt(input[1]) - 1;

            if (placeKimBap(sCol, 1, i)) return;
            if (placeKimBap(jCol, 2, i)) return;
        }

        System.out.println("ss");
    }

    private static boolean placeKimBap(int col, int player, int turn) {
        int row = height[col]++;
        board[row][col] = player;

        if (checkWin(row, col, player)) {
            System.out.println((player == 1 ? "sk " : "ji ") + turn);
            return true;
        }
        return false;
    }

    private static boolean checkWin(int r, int c, int player) {
        return checkDirection(r, c, player, 1, 0) || // 가로 →
                checkDirection(r, c, player, 0, 1) || // 세로 ↓
                checkDirection(r, c, player, 1, 1) || // 대각선 ↘
                checkDirection(r, c, player, 1, -1);  // 대각선 ↙
    }

    private static boolean checkDirection(int r, int c, int player, int dx, int dy) {
        int count = 1;
        for (int i = 1; i < 4; i++) { // 한쪽 방향으로 검사
            int nr = r + i * dx, nc = c + i * dy;
            if (nr < 0 || nr >= 6 || nc < 0 || nc >= 7 || board[nr][nc] != player) break;
            count++;
        }
        for (int i = 1; i < 4; i++) { // 반대 방향으로 검사
            int nr = r - i * dx, nc = c - i * dy;
            if (nr < 0 || nr >= 6 || nc < 0 || nc >= 7 || board[nr][nc] != player) break;
            count++;
        }
        return count >= 4; // 4개 이상 연속되면 승리
    }
}
