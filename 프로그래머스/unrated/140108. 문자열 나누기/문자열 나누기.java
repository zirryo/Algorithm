class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = 0;
        int my = 0;
        int diff = 0;
        for(int i=0; i<s.length(); i++) {
            if(my == diff) {
                answer++;
                my = 0;
                diff = 0;
                c = s.charAt(i);
            }
            if(c == s.charAt(i)) my++;
            else diff++;
        }
        return answer;
    }
}