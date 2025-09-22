import java.io.*;
import java.util.*;

public class Main {
    static int L, N;
    static String[] words;
    static List<String> square = new ArrayList<>();
    static boolean[] used;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words);
        used = new boolean[N];

        backtrack(0);

        if (!found) {
            System.out.println("NONE");
        }
    }

    static void backtrack(int depth) {
        if (found) return;
        if (depth == L) {
            for (String w : square) System.out.println(w);
            found = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i] && isValid(words[i], depth)) {
                used[i] = true;
                square.add(words[i]);

                backtrack(depth + 1);

                square.remove(square.size() - 1);
                used[i] = false;
            }
        }
    }

    static boolean isValid(String w, int step) {
        for (int i = 0; i < step; i++) {
            if (square.get(i).charAt(step) != w.charAt(i)) return false;
        }
        return true;
    }
}
