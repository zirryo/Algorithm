import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!isCycleWordPresent(set, word)) {
                set.add(word);
            }
        }

        System.out.println(set.size());
    }

    private static boolean isCycleWordPresent(Set<String> set, String word) {
        int length = word.length();
        String temp = word + word;

        for (int i = 0; i < length; i++) {
            if (set.contains(temp.substring(i, i + length))) {
                return true;
            }
        }

        return false;
    }
}
