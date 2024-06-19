import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        Map<String, Integer> patternMap = new HashMap<>();
        for (String word : words) {
            String pattern = getPattern(word);
            patternMap.put(pattern, patternMap.getOrDefault(pattern, 0) + 1);
        }

        int similarPairs = 0;
        for (int count : patternMap.values()) {
            if (count > 1) {
                similarPairs += (count * (count - 1)) / 2;
            }
        }

        System.out.println(similarPairs);
    }

    private static String getPattern(String word) {
        Map<Character, Integer> charMap = new HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int nextNumber = 1;

        for (char c : word.toCharArray()) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, nextNumber++);
            }
            pattern.append(charMap.get(c)).append(" ");
        }

        return pattern.toString().trim();
    }
}
