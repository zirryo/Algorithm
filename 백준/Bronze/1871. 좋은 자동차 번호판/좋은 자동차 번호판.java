import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String plate = br.readLine().trim();
            String left = plate.substring(0, 3);
            String right = plate.substring(4);

            int leftValue = (left.charAt(0) - 'A') * 26 * 26
                    + (left.charAt(1) - 'A') * 26
                    + (left.charAt(2) - 'A');

            int rightValue = Integer.parseInt(right);

            if (Math.abs(leftValue - rightValue) <= 100) {
                sb.append("nice\n");
            } else {
                sb.append("not nice\n");
            }
        }

        System.out.println(sb);
    }
}
