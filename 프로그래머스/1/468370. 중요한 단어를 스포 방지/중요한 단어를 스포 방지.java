import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] isSpoiler = new boolean[n];
        
        for (int[] range : spoiler_ranges) {
            int start = range[0];
            int end = range[1];
            for (int i = start; i <= end; i++) {
                isSpoiler[i] = true;
            }
        }
        
        Set<String> normalWords = new HashSet<>();
        List<String> spoilerWords = new ArrayList<>();
        
        int i = 0;
        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            int startIdx = i;
            while (i < n && message.charAt(i) != ' ') {
                i++;
            }
            int endIdx = i - 1;
            
            String word = message.substring(startIdx, endIdx + 1);
            
            boolean spoiled = false;
            for (int j = startIdx; j <= endIdx; j++) {
                if (isSpoiler[j]) {
                    spoiled = true;
                    break;
                }
            }
            
            if (spoiled) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
        }
        
        Set<String> alreadySpoiled = new HashSet<>();
        int result = 0;
        
        for (String word : spoilerWords) {
            if (!normalWords.contains(word) && !alreadySpoiled.contains(word)) {
                result++;
                alreadySpoiled.add(word);
            }
        }
        
        return result;
    }
}