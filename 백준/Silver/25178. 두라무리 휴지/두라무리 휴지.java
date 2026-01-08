import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        if (isDurumari(s1, s2, N)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean isDurumari(String s1, String s2, int n) {
        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(n - 1) != s2.charAt(n - 1)) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[c1[i] - 'a']++;
            count[c2[i] - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }

        int idx1 = 1;
        int idx2 = 1;

        while (idx1 < n-1 && idx2 < n-1) {
            while (isVowel(c1[idx1]) && idx1 < n-1) {
                idx1++;
            }

            while (isVowel(c2[idx2]) && idx2 < n-1) {
                idx2++;
            }

            if (c1[idx1] == c2[idx2]) {
                idx1++;
                idx2++;
            } else {
                return false;
            }

        }

        return true;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}