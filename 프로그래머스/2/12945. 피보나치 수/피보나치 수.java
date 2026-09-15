class Solution {
    public int solution(int n) {
        int MOD = 1234567;
        
        int prev2 = 0; 
        int prev1 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}