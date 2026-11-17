class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows + 1][columns + 1];
        int num = 1;
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                matrix[r][c] = num++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotateAndGetMin(matrix, queries[i]);
        }

        return answer;
    }

    private int rotateAndGetMin(int[][] matrix, int[] query) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int temp = matrix[x1][y1];
        int minVal = temp;

        for (int r = x1; r < x2; r++) {
            matrix[r][y1] = matrix[r + 1][y1];
            minVal = Math.min(minVal, matrix[r][y1]);
        }

        for (int c = y1; c < y2; c++) {
            matrix[x2][c] = matrix[x2][c + 1];
            minVal = Math.min(minVal, matrix[x2][c]);
        }

        for (int r = x2; r > x1; r--) {
            matrix[r][y2] = matrix[r - 1][y2];
            minVal = Math.min(minVal, matrix[r][y2]);
        }

        for (int c = y2; c > y1 + 1; c--) {
            matrix[x1][c] = matrix[x1][c - 1];
            minVal = Math.min(minVal, matrix[x1][c]);
        }

        matrix[x1][y1 + 1] = temp;

        return minVal;
    }
}