import java.io.*;

public class Main {
    static int N;
    static char[] input;
    static boolean found = false;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        dfs(0, 0, new StringBuilder());
        System.out.println(answer);
    }

    static void dfs(int idx, int open, StringBuilder sb) {
        if (found) return;

        if (open < 0 || open > N / 2) return; // 정상적인 괄호 문자열이 아님

        if (idx == N) {
            if (open == 0) {
                answer = new StringBuilder(sb);
                found = true;
            }
            return;
        }

        char c = input[idx];
        if (c == 'G') {
            sb.append('(');
            dfs(idx + 1, open + 1, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(')');
            dfs(idx + 1, open - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (c == '(') {
            sb.append('(');
            dfs(idx + 1, open + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(')');
            dfs(idx + 1, open - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
