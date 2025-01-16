import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            char[] encrypted = br.readLine().toCharArray();
            int N = encrypted.length;
            int L = (int) Math.sqrt(N);

            for (int i = L-1; i >= 0; i--) {
                for (int j = 0; j < L; j++) {
                    sb.append(encrypted[j * L + i]);
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
