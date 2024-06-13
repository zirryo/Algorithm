import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("*")) {
                break;
            }
            if (isSurprising(input)) {
                sb.append(input + " is surprising.\n");
            } else {
                sb.append(input + " is NOT surprising.\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isSurprising(String str) {
        int len = str.length();
        for (int d = 1; d < len; d++) {
            Set<String> pairs = new HashSet<>();
            for (int i = 0; i + d < len; i++) {
                String pair = "" + str.charAt(i) + str.charAt(i + d);
                if (pairs.contains(pair)) {
                    return false;
                }
                pairs.add(pair);
            }
        }
        return true;
    }
}
