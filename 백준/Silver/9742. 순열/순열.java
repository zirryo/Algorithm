import java.io.*;
import java.util.*;

public class Main {
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        factorial = new long[11];
        factorial[0] = 1;
        for (int i = 1; i <= 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) break;

            String s = st.nextToken();
            long k = Long.parseLong(st.nextToken());
            int n = s.length();

            sb.append(s).append(" ").append(k).append(" = ");

            if (k > factorial[n]) { // 순열 범위 초과하는 경우
                sb.append("No permutation\n");
                continue;
            }

            k--;
            List<Character> chars = new ArrayList<>();
            for (char c : s.toCharArray()) chars.add(c);

            for (int i = n - 1; i >= 0; i--) {
                int index = (int) (k / factorial[i]);
                sb.append(chars.get(index));
                chars.remove(index);
                k %= factorial[i];
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}