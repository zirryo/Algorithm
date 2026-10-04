import java.util.*;

class Solution {

    private int n;
    private int[][] q;
    private int[] ans;
    private int validCodeCount;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.validCodeCount = 0;

        int[] selected = new int[5];
        comb(1, 0, selected);

        return validCodeCount;
    }

    private void comb(int start, int depth, int[] selected) {
        if (depth == 5) {
            if (isValid(selected)) {
                validCodeCount++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            comb(i + 1, depth + 1, selected);
        }
    }

    private boolean isValid(int[] selected) {
        for (int i = 0; i < q.length; i++) {
            int match = 0;
            int[] query = q[i];

            int p1 = 0, p2 = 0;
            while (p1 < 5 && p2 < 5) {
                if (selected[p1] == query[p2]) {
                    match++;
                    p1++;
                    p2++;
                } else if (selected[p1] < query[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }

            if (match != ans[i]) {
                return false;
            }
        }
        return true;
    }
}