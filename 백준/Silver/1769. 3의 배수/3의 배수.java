import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();

        int count = 0;

        while (X.length() > 1) {
            int sum = 0;
            for (char c : X.toCharArray()) {
                sum += c - '0';
            }
            X = Integer.toString(sum);
            count++;
        }

        int finalNumber = Integer.parseInt(X);
        System.out.println(count);
        System.out.println(finalNumber % 3 == 0 ? "YES" : "NO");
    }
}
