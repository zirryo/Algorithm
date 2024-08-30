import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String message = br.readLine();
            int[] count = new int[26];
            boolean isFake = false;

            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                int idx = c - 'A';
                count[idx]++;

                if (count[idx] == 3) {
                    if (i + 1 < message.length() && message.charAt(i + 1) == c) {
                        count[idx] = 0;
                        i++;
                    } else {
                        isFake = true;
                        break;
                    }
                }
            }

            if (isFake) {
                sb.append("FAKE\n");
            } else {
                sb.append("OK\n");
            }
        }

        System.out.println(sb);

    }
}