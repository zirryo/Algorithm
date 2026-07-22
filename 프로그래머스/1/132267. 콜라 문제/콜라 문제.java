class Solution {
    public int solution(int a, int b, int n) {
        int totalCoke = 0;

        while (n >= a) {
            int newCoke = (n / a) * b;
            int remain = n % a;
            
            totalCoke += newCoke;
            n = newCoke + remain;
        }
        
        return totalCoke;
    }
}