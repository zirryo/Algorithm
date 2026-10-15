import java.util.Arrays;

class Solution {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int charIdx = ch - 'a';

            if (lastSeen[charIdx] != -1) {
                answer[i] = i - lastSeen[charIdx];
            } else {
                answer[i] = -1;
            }

            lastSeen[charIdx] = i;
        }

        return answer;
    }
}