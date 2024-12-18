import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }

            String palindrome = findPalindrome(words);
            result.append(palindrome).append("\n");
        }

        System.out.print(result);
    }

    private static String findPalindrome(String[] words) {
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String combined = words[i] + words[j];
                    if (isPalindrome(combined)) {
                        return combined;
                    }
                }
            }
        }

        return "0";
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
