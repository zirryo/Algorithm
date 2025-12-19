import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.sort((a, b) -> b.length() - a.length());

        List<String> selected = new ArrayList<>();

        for (String w : words) {
            boolean ok = true;
            for (String s : selected) {
                if (s.startsWith(w)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                selected.add(w);
            }
        }

        System.out.println(selected.size());
    }
}
