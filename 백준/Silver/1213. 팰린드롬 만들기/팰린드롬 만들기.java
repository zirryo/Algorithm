import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] charCount = new int[26];

        for (char c : input.toCharArray()) {
            charCount[c - 'A']++;
        }

        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charCount[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half); // 앞부분
        if (oddCount == 1) result.append(oddChar); // 홀수 문자
        result.append(half.reverse()); // 뒷부분 (뒤집기)

        System.out.println(result);
    }
}
