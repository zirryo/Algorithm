import java.util.Arrays;

class Solution {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int targetCol = col - 1;

        Arrays.sort(data, (a, b) -> {
            if (a[targetCol] != b[targetCol]) {
                return Integer.compare(a[targetCol], b[targetCol]);
            }
            return Integer.compare(b[0], a[0]); 
        });

        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int[] row = data[i - 1];
            int sum = 0;

            for (int val : row) {
                sum += val % i;
            }

            answer ^= sum;
        }

        return answer;
    }
}