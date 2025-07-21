import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static final String vowels = "aiyeou";
    static final String consonants = "bkxznhdcwgpvjqtsrlmf";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            StringBuilder decoded = new StringBuilder();

            for (char ch : line.toCharArray()) {
                decoded.append(decodeChar(ch));
            }

            output.append(decoded).append("\n");
        }

        System.out.print(output);
    }

    static char decodeChar(char ch) {
        boolean isUpper = Character.isUpperCase(ch);
        char lower = Character.toLowerCase(ch);

        int idx;

        if ((idx = vowels.indexOf(lower)) != -1) {
            int newIdx = (idx + 3) % 6;
            char decoded = vowels.charAt(newIdx);
            return isUpper ? Character.toUpperCase(decoded) : decoded;

        } else if ((idx = consonants.indexOf(lower)) != -1) {
            int newIdx = (idx + 10) % 20;
            char decoded = consonants.charAt(newIdx);
            return isUpper ? Character.toUpperCase(decoded) : decoded;

        } else {
            return ch;
        }
    }
}
