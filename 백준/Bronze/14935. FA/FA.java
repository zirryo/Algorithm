import java.io.*;
import java.util.*;

public class Main {
    static int F(String x) {
        int firstDigit = x.charAt(0) - '0';
        int length = x.length();
        return firstDigit * length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine().trim(); // 최대 100자리 자연수

        Set<String> visited = new HashSet<>();

        while (true) {
            if (visited.contains(x)) {
                System.out.println("FA");
                return;
            }
            visited.add(x);
            int fx = F(x);
            x = String.valueOf(fx);
        }
    }
}
