import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            if (isValid(input)) sb.append(String.format("<%s> is acceptable.\n", input));
            else sb.append(String.format("<%s> is not acceptable.\n", input));
        }

        System.out.println(sb);

    }
    private static boolean isValid(String input) {
        input += " ";
        char[] chars = input.toCharArray();
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        boolean hasVowel = false;

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            boolean isVowel = false;
            if (chars[i] == chars[i + 1]) {
                if (chars[i] != 'e' && chars[i] != 'o') return false;
            }
            for (char vowel : vowels) {
                if (chars[i] == vowel) {
                    hasVowel = true;
                    isVowel = true;
                    vowelCount++;
                    consonantCount = 0;
                }
            }

            if (!isVowel) {
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount >= 3 || consonantCount >= 3) return false;
        }

        return hasVowel;
    }
}
