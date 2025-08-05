import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count[c - 'A']++;
        }

        int max = -1;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) (i + 'A');
            } else if (count[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
