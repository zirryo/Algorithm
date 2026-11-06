class Solution {

    public int[] solution(int n) {
        int[][] board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = new int[i + 1];
        }

        int totalCount = n * (n + 1) / 2;
        int num = 1;
        int row = -1;
        int col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else if (i % 3 == 2) {
                    row--;
                    col--;
                }
                board[row][col] = num++;
            }
        }

        int[] answer = new int[totalCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = board[i][j];
            }
        }

        return answer;
    }
}