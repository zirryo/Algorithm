import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != 'J' && c != 'A' && c != 'V') {
                sb.append(c);
            }
        }

        if (sb.length() == 0) {
            System.out.println("nojava");
        } else {
            System.out.println(sb);
        }
    }
}
