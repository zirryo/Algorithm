import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String bStr = br.readLine();
            String aStr = br.readLine();
            String revBStr = new StringBuilder(bStr).reverse().toString();
            String bMin = bStr.compareTo(revBStr) < 0 ? bStr : revBStr;

            Integer[] aCards = new Integer[n];
            for (int i = 0; i < n; i++) aCards[i] = aStr.charAt(i) - '0';
            Arrays.sort(aCards, Collections.reverseOrder());

            String result = solve(n, bMin, aCards);
            ans.append(result).append("\n");
        }
        System.out.println(ans);
    }

    static String solve(int n, String bMin, Integer[] aCards) {
        boolean[] used = new boolean[n];
        StringBuilder cur = new StringBuilder();

        if (findNLength(0, true, used, cur, bMin, aCards)) {
            return cur.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(aCards[i]);
        }
        return sb.length() == 0 ? aCards[0].toString() : sb.toString();
    }

    static boolean findNLength(int depth, boolean isTight, boolean[] used, StringBuilder sb, String bMin, Integer[] aCards) {
        if (depth == bMin.length()) {
            return false;
        }

        int target = bMin.charAt(depth) - '0';

        for (int i = 0; i < aCards.length; i++) {
            if (used[i]) continue;

            if (isTight) {
                if (aCards[i] < target) {
                    // 타겟보다 작은 숫자를 쓰는 순간, 나머지는 가장 큰 순서대로 채움
                    sb.append(aCards[i]);
                    used[i] = true;
                    fillRemaining(sb, used, aCards);
                    return true;
                } else if (aCards[i] == target) {
                    sb.append(aCards[i]);
                    used[i] = true;
                    if (findNLength(depth + 1, true, used, sb, bMin, aCards)) return true;
                    used[i] = false;
                    sb.setLength(sb.length() - 1);
                }
            }
        }
        return false;
    }

    static void fillRemaining(StringBuilder sb, boolean[] used, Integer[] aCards) {
        for (int i = 0; i < aCards.length; i++) {
            if (!used[i]) sb.append(aCards[i]);
        }
    }
}