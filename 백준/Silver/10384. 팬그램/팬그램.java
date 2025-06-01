import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int t = 1; t <= n; t++) {
            String line = br.readLine();
            int[] count = new int[26];

            for (char ch : line.toCharArray()) {
                if (Character.isLetter(ch)) {
                    count[Character.toLowerCase(ch) - 'a']++;
                }
            }

            int min = Arrays.stream(count).min().getAsInt();

            sb.append("Case " + t + ": ");
            if (min >= 3) {
                sb.append("Triple pangram!!!\n");
            } else if (min == 2) {
                sb.append("Double pangram!!\n");
            } else if (min == 1) {
                sb.append("Pangram!\n");
            } else {
                sb.append("Not a pangram\n");
            }
        }

        System.out.println(sb);
    }
}
