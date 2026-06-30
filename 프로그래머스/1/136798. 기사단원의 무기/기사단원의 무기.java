class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int divisorCount = getCnt(i, limit);

            if (divisorCount > limit) {
                answer += power;
            } else {
                answer += divisorCount;
            }
        }
        
        return answer;
    }
    
    private int getCnt(int num, int limit) {
        int count = 0;
        
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) {
                count += 1; 
            } else if (num % i == 0) {
                count += 2;
            }
            
            if (count > limit) break;
        }
        
        return count;
    }
}