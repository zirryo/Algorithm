class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int remainder = storey % 10;
            int next = (storey / 10) % 10;

            if (remainder > 5) {
                answer += (10 - remainder);
                storey += 10; 
            } else if (remainder < 5) {
                answer += remainder;
            } else {
                answer += 5;
                if (next >= 5) {
                    storey += 10;
                }
            }

            storey /= 10;
        }

        return answer;
    }
}