import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }
    static int M, N, answer;
    static char[][] block;
    static boolean[][] visited;
    public int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        answer = 0;
        block = new char[M][N];
        for(int i=0; i<M; i++) {
            String s = board[i];
            for(int j=0; j<N; j++) {
                block[i][j] = s.charAt(j);
            }
        }
        getScore();
        return answer;
    }
    public void getScore() {
        ArrayList<Character>[] charList;
        while (true) {
            int cnt = 0; // 삭제된 블록의 수
            visited = new boolean[M][N];
            for(int i = 0; i < M-1; i++) {
                for(int j = 0; j < N-1; j++) {
                    if(block[i][j] == 0) continue;
                    boolean flag = fourBlock(i, j);
                    if(flag) {
                        fourBlock(i, j+1);
                        fourBlock(i+1, j);
                        fourBlock(i+1, j+1);
                    }
                }
            }
            charList = new ArrayList[N];
            for(int i = 0; i < N; i++) charList[i] = new ArrayList<>(); // 2차원배열의 각 열에 포함된 값 저장
            for(int i = 0; i < N; i++) {
                for(int j = M-1; j >= 0; j--) { // 4블록이 된 블록을 삭제하고 다시 block[][]에 담음
                    if(!visited[j][i]) charList[i].add(block[j][i]);
                    else cnt++;
                }
            }
            if(cnt == 0) break; // 더 이상 블록이 삭제되지 않는다면 반복문 종료
            answer += cnt;

            block = new char[M][N]; // 블록 배치 갱신 (삭제된 블록 반영)
            for(int i = 0; i < N; i++) {
                for(int j = M-1; j >= 0; j--) {
                    if(!charList[i].isEmpty()) {
                        block[j][i] = charList[i].get(0);
                        charList[i].remove(0);
                    }
                }
            }
        }
    }
    public boolean fourBlock(int x, int y) {
        if(x + 1 >= M || y + 1 >= N) return false;
        char cur = block[x][y];
        if(cur == 0 || cur != block[x+1][y] || cur != block[x][y+1] || cur != block[x+1][y+1]) return false;
        visited[x][y] = true;
        visited[x+1][y] = true;
        visited[x][y+1] = true;
        visited[x+1][y+1] = true;
        return true;
    }
}