import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] parts = br.readLine().split(" ");
            String s = parts[0];
            String p = parts[1];

            int count = 0;
            int i = 0;
            while (i < s.length()) {
                if (i + p.length() <= s.length() && s.startsWith(p, i)) {
                    count++;
                    i += p.length();
                } else {
                    count++;
                    i++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
