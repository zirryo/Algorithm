class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int len = board.length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
            if (board[h][w].equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
}