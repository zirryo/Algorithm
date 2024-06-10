import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int SIZE = 9;
    private static int[][] board = new int[SIZE][SIZE];
    private static boolean[][] rows = new boolean[SIZE][SIZE + 1]; // i번째 row의 1-9 사용여부 체크
    private static boolean[][] cols = new boolean[SIZE][SIZE + 1]; // j번째 col의 1-9 사용여부 체크
    private static boolean[][] boxes = new boolean[SIZE][SIZE + 1]; // // k번째 box의 1-9 사용여부 체크
    private static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++) {
            String line = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex(i, j)][num] = true;
                }
            }
        }
        solve(0, 0);
    }

    private static void solve(int row, int col) {
        if (row == SIZE) {
            printBoard();
            solved = true;
            return;
        }

        if (col == SIZE) {
            solve(row + 1, 0);
            return;
        }

        if (board[row][col] != 0) {
            solve(row, col + 1);
            return;
        }

        for (int num = 1; num <= SIZE; num++) {
            if (!rows[row][num] && !cols[col][num] && !boxes[boxIndex(row, col)][num]) {
                board[row][col] = num;
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[boxIndex(row, col)][num] = true;

                solve(row, col + 1);

                if (solved) return;

                board[row][col] = 0;
                rows[row][num] = false;
                cols[col][num] = false;
                boxes[boxIndex(row, col)][num] = false;
            }
        }
    }

    private static int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}