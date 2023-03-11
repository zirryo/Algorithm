class Solution {
    static int maxDiff = 0;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        int[] ryan = new int[11];
        dfs(0, n, ryan, info);
        if(maxDiff <= 0) return new int[]{-1};
        return answer;
    }
    public void dfs(int depth, int arrow, int[] ryan, int[] apeach) {
        if(arrow == 0 || depth == 11) {
            ryan[10] += arrow; // 남은 화살은 모두 가장 낮은 점수에 배정
            calculateScore(ryan, apeach);
            ryan[10] -= arrow;
            return;

        }
        if(apeach[depth] < arrow) {
            ryan[depth] += (apeach[depth] + 1);
            dfs(depth+1, arrow-apeach[depth]-1, ryan, apeach);
            ryan[depth] -= (apeach[depth] + 1);
        }
        dfs(depth+1, arrow, ryan, apeach);
    }
    public void calculateScore(int[] ryan, int[] apeach) {
        int r = 0;
        int a = 0;
        for(int i = 0; i < 11; i++) {
            if(ryan[i] > apeach[i]) r += (10-i);
            else if(apeach[i] > 0) a += (10-i);
        }

        int diff = r - a;
        if(diff > 0 && diff >= maxDiff) {
            if(maxDiff==diff && !isAnswer(ryan)) return;
            maxDiff = diff;
            answer = ryan.clone();
        }
    }
    public boolean isAnswer(int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if(ryan[i] > answer[i]) return true;
            else if(ryan[i] < answer[i]) return false;
        }
        return true;
    }
}