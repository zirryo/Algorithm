import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            paper = br.readLine().toCharArray();
            boolean result = isValid(0, paper.length - 1);
            if (result) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
    private static boolean isValid(int l, int r) {
        if (l == r) return true; // 길이가 1일 경우 어떤 방향이어도 상관없음.

        int mid = (l + r) / 2;
        for (int idx = l; idx < mid; idx++) {
            if (paper[idx] == paper[r-idx]) return false;
        }

        return isValid(l, mid-1) && isValid(mid+1, r);
    }
}