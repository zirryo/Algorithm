class Solution {

    public int solution(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int maxLen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    maxLen = 1;
                    break;
                }
            }
            if (maxLen == 1) break;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    int min = Math.min(board[i - 1][j], 
                                       Math.min(board[i][j - 1], board[i - 1][j - 1]));
                    board[i][j] = min + 1;
                    maxLen = Math.max(maxLen, board[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}