import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int plusIdx = s.indexOf('+');
        if (plusIdx == -1 || plusIdx != s.lastIndexOf('+')) {
            System.out.println("No Money");
            return;
        }

        String left = s.substring(0, plusIdx);
        String right = s.substring(plusIdx + 1);

        if (left.length() == 0 || right.length() == 0) {
            System.out.println("No Money");
            return;
        }
        if (left.length() > 1 && left.charAt(0) == '0') {
            System.out.println("No Money");
            return;
        }
        if (left.length() == 1 && left.charAt(0) == '0') {
            System.out.println("No Money");
            return;
        }

        if (!isAllDigits(left) || !isAllDigits(right)) {
            System.out.println("No Money");
            return;
        }

        if (left.equals(right)) {
            System.out.println("CUTE");
        } else {
            System.out.println("No Money");
        }
    }

    static boolean isAllDigits(String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}
