class Solution {

    private int[] answer = new int[2]; 

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    private void compress(int[][] arr, int r, int c, int size) {
        if (isSame(arr, r, c, size)) {
            answer[arr[r][c]]++;
            return;
        }

        int half = size / 2;
        compress(arr, r, c, half);               
        compress(arr, r, c + half, half);        
        compress(arr, r + half, c, half);        
        compress(arr, r + half, c + half, half); 
    }

    private boolean isSame(int[][] arr, int r, int c, int size) {
        int target = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}