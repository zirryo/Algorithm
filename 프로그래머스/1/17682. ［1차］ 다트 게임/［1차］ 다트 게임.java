class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;
        
        char[] chars = dartResult.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            
            if (Character.isDigit(c)) {
                idx++;

                if (c == '1' && i + 1 < chars.length && chars[i + 1] == '0') {
                    scores[idx] = 10;
                    i++; 
                } else {
                    scores[idx] = c - '0';
                }
            } 

            else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'D') {
                    scores[idx] = (int) Math.pow(scores[idx], 2);
                } else if (c == 'T') {
                    scores[idx] = (int) Math.pow(scores[idx], 3);
                }
               
            } 

            else if (c == '*') {
                scores[idx] *= 2; 
                if (idx > 0) {
                    scores[idx - 1] *= 2;
                }
            } else if (c == '#') {
                scores[idx] *= -1; 
            }
        }
        
        int answer = 0;
        for (int score : scores) {
            answer += score;
        }
        
        return answer;
    }
}