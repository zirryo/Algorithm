import java.io.*;
import java.util.*;

public class Main {
    static int N, idx;
    static String[] words;
    static HashSet<String> usedWords = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            if (!words[i].equals("?")) usedWords.add(words[i]);
            else idx = i; 
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String candidate = br.readLine();

            if (usedWords.contains(candidate)) continue;

            if ((idx > 0 && !words[idx - 1].endsWith(candidate.substring(0, 1))) ||
                    (idx < N - 1 && !candidate.endsWith(words[idx + 1].substring(0, 1)))) {
                continue;
            }

            System.out.println(candidate);
            return;
        }
    }
}
