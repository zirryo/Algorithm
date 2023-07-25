import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 1; i < str1.length(); i++) {
            String s = str1.substring(i-1, i+1);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }
        for (int i = 1; i < str2.length(); i++) {
            String s = str2.substring(i-1, i+1);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }
        int union = 0;
        int intersection = 0;
        for (String str : set) {
            union += Math.max(map1.getOrDefault(str, 0), map2.getOrDefault(str, 0));
            intersection += Math.min(map1.getOrDefault(str, 0), map2.getOrDefault(str, 0));
        }

        if (union == 0 && intersection == 0) return 65536;
        else {
            return intersection * 65536 / union;
        }
    }
}