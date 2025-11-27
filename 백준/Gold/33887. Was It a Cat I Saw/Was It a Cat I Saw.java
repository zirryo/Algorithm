import java.io.*;

public class Main {

    static boolean isPalindrome(int x) {
        String s = Integer.toBinaryString(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int X = Integer.parseInt(br.readLine().trim());

            if (isPalindrome(X)) {
                sb.append(0).append('\n');
                continue;
            }

            int k = 1;
            while (true) {
                if (X - k >= 1 && isPalindrome(X - k)) {
                    sb.append(k).append('\n');
                    break;
                }
                if (X + k <= 1_500_000_000 && isPalindrome(X + k)) {
                    sb.append(k).append('\n');
                    break;
                }
                k++;
            }
        }

        System.out.print(sb);
    }
}
