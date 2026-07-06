import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> basket = new Stack<>();
        
        int[] topRow = new int[n];
        
        for (int col = 0; col < n; col++) {
            int firstDollRow = n;
            for (int row = 0; row < n; row++) {
                if (board[row][col] != 0) {
                    firstDollRow = row;
                    break; 
                }
            }
            topRow[col] = firstDollRow;
        }
        
        for (int move : moves) {
            int col = move - 1;
            int currentRow = topRow[col];
            
            if (currentRow >= n) {
                continue;
            }
            
            int doll = board[currentRow][col];
            board[currentRow][col] = 0; 
            topRow[col]++;
            
            if (!basket.isEmpty() && basket.peek() == doll) {
                basket.pop();
                answer += 2;
            } else {
                basket.push(doll);
            }
        }
        
        return answer;
    }
}