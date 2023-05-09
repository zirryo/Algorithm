import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backTracking("");
    }
    private static void backTracking(String s) {
        if(s.length() == n) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(s + i)) backTracking(s + i);
            // 좋은 수열일때만 탐색을 계속 진행한다
        }
    }
    private static boolean isGood(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String left = s.substring(s.length() - i * 2, s.length() - i);
            String right = s.substring(s.length() - i);
            if(left.equals(right)) return false;
        }
        return true;
    }
}