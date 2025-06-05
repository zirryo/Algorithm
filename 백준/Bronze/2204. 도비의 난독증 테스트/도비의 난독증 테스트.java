import java.io.*;
import java.util.*;

public class Main {
    static class Word {
        String original;
        String lower;

        Word(String word) {
            this.original = word;
            this.lower = word.toLowerCase();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            List<Word> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                words.add(new Word(input));
            }

            words.sort(Comparator.comparing(w -> w.lower));
            sb.append(words.get(0).original).append('\n');
        }

        System.out.print(sb);
    }
}
