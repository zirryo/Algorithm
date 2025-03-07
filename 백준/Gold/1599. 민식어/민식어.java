import java.io.*;
import java.util.*;

public class Main {
    static final List<String> MINSIK_ALPHABET = Arrays.asList(
            "a", "b", "k", "d", "e", "g", "h", "i", "l", "m", "n", "ng",
            "o", "p", "r", "s", "t", "u", "w", "y"
    );
    static final Map<String, Integer> ORDER_MAP = new HashMap<>();

    static {
        for (int i = 0; i < MINSIK_ALPHABET.size(); i++) {
            ORDER_MAP.put(MINSIK_ALPHABET.get(i), i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, Main::compareMinsik);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }

    private static int compareMinsik(String w1, String w2) {
        List<Integer> list1 = toMinsikIndices(w1);
        List<Integer> list2 = toMinsikIndices(w2);

        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i) - list2.get(i);
            }
        }
        return list1.size() - list2.size();
    }

    private static List<Integer> toMinsikIndices(String word) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (i < word.length() - 1 && word.startsWith("ng", i)) {
                indices.add(ORDER_MAP.get("ng"));
                i++;
            } else {
                indices.add(ORDER_MAP.get(String.valueOf(word.charAt(i))));
            }
        }
        return indices;
    }
}
