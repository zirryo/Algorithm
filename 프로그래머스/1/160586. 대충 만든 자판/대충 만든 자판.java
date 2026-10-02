import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minPressMap = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int pressCount = i + 1; 

                minPressMap.put(ch, Math.min(minPressMap.getOrDefault(ch, 101), pressCount));
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;
            boolean possible = true;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);

                if (minPressMap.containsKey(ch)) {
                    totalPress += minPressMap.get(ch);
                } else {
                    possible = false;
                    break;
                }
            }

            answer[i] = possible ? totalPress : -1;
        }

        return answer;
    }
}