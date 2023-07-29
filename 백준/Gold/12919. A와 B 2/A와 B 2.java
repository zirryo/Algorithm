import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        len = S.length();

        String T = br.readLine();
        backTracking(T);
        System.out.println(0);
    }
    private static void backTracking(String str) {
        if (str.length() < len) return;
        if (str.equals(S)) {
            System.out.println(1);
            System.exit(0);
        }

        if (str.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(str.substring(1));
            backTracking(sb.reverse().toString());
        }
        if(str.charAt(str.length() - 1) == 'A') {
            backTracking(str.substring(0, str.length() - 1));
        }
    }
}