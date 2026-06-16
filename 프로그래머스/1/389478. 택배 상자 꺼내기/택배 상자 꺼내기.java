class Solution {
    public int solution(int n, int w, int num) {
        int numRow = (num - 1) / w;
        int numCol = getCol(numRow, w, num);
        
        int answer = 0;
        int currentRow = numRow;
        
        while (true) {
            int currentBoxNum = getBoxNumber(currentRow, w, numCol);
            if (currentBoxNum > n) {
                break;
            }
            
            answer++;
            currentRow++;
        }
        
        return answer;
    }
    
    private int getCol(int row, int w, int boxNum) {
        int remainder = (boxNum - 1) % w;
        if (row % 2 == 0) {
            return remainder; 
        } else {
            return w - 1 - remainder; 
        }
    }
    
    private int getBoxNumber(int row, int w, int col) {
        if (row % 2 == 0) {
            return row * w + col + 1;
        } else {
            return row * w + (w - 1 - col) + 1;
        }
    }
}