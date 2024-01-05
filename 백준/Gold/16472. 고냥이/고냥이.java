import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new TreeSet<>();
        String s = br.readLine();
        int[] cnt = new int[26];
        int len = s.length();
        int max = 0;
        int p = 0;
        int q = 0;

        while (p <= q && q < len) {
            char cur = s.charAt(q);
            cnt[cur - 'a']++;
            if (!set.contains(cur)) {
                while (set.size() >= N) {
                    int x = s.charAt(p) - 'a';
                    if (cnt[x] == 1) {
                        set.remove(s.charAt(p));
                    }
                    cnt[x]--;
                    p++;
                }

                set.add(cur);
            }
            max = Math.max(max, q - p + 1);
            q++;
        }
        System.out.println(max);
    }
}