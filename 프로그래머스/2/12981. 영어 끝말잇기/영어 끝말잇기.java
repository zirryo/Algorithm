import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char prev = words[0].charAt(0);
        Set<String> used = new HashSet<>();
        boolean success = true;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) != prev) {
                success = false;
            }
            
            if (!used.add(words[i])) {
                success = false;
            }
            
            if (words[i].length() == 1) {
                success = false;
            }
            
            if (!success) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            prev = words[i].charAt(words[i].length()-1);
        }
        
        return answer;
    }
}