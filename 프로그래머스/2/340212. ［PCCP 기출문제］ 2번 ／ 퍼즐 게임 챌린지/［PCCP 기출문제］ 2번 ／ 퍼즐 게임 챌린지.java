class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSolve(diffs, times, limit, mid)) {
                answer = mid;       
                right = mid - 1;    
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = (i > 0) ? times[i - 1] : 0;

            if (diff <= level) {
                totalTime += timeCur;
            } else {
                long mistakes = diff - level;
                totalTime += mistakes * (timeCur + timePrev) + timeCur;
            }

            if (totalTime > limit) {
                return false;
            }
        }

        return true;
    }
}