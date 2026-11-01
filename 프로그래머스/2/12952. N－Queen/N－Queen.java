class Solution {
    private int count = 0;
    private int[] board;

    public int solution(int n) {
        board = new int[n];
        backtrack(0, n);
        return count;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col;

            if (isValid(row)) {
                backtrack(row + 1, n);
            }
        }
    }

    private boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}