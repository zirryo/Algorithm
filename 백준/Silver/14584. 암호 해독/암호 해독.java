import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String encrypted = br.readLine();
        int len = encrypted.length();

        int[] shiftPattern = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            shiftPattern[i] = ((encrypted.charAt(i + 1) - encrypted.charAt(i) + 26) % 26);
        }

        int N = Integer.parseInt(br.readLine());
        String originalText = "";

        for (int t = 0; t < N; t++) {
            String word = br.readLine();
            int wordLen = word.length();

            int[] wordShift = new int[wordLen - 1];
            for (int i = 0; i < wordLen - 1; i++) {
                wordShift[i] = ((word.charAt(i + 1) - word.charAt(i) + 26) % 26);
            }

            for (int i = 0; i <= len - wordLen; i++) {
                boolean match = true;

                for (int j = 0; j < wordLen - 1; j++) {
                    if (shiftPattern[i + j] != wordShift[j]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    int shift = (word.charAt(0) - encrypted.charAt(i) + 26) % 26;

                    StringBuilder decrypted = new StringBuilder();
                    for (int j = 0; j < len; j++) {
                        char decryptedChar = (char) ('a' + ((encrypted.charAt(j) - 'a' + shift + 26) % 26));
                        decrypted.append(decryptedChar);
                    }

                    originalText = decrypted.toString();
                    break;
                }
            }

            if (!originalText.isEmpty()) break;
        }

        System.out.println(originalText);
    }
}
