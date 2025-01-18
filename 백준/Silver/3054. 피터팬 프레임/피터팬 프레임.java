import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();

        StringBuilder[] result = new StringBuilder[5];
        for (int i = 0; i < 5; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i++) {
            char ch = input.charAt(i);

            boolean isWendy = (i % 3 == 2);
            boolean wasWendy = (i % 3 == 0 && i != 0);

            result[0].append(isWendy ? "..*." : "..#.");
            result[1].append(isWendy ? ".*.*" : ".#.#");

            result[2].append((isWendy || wasWendy) ? "*." : "#.");
            result[2].append(ch);
            result[2].append(".");

            result[3].append(isWendy ? ".*.*" : ".#.#");
            result[4].append(isWendy ? "..*." : "..#.");

        }

        result[0].append('.');
        result[1].append('.');
        result[3].append('.');
        result[4].append('.');

        if (n % 3 == 0) {
            result[2].append('*');
        } else {
            result[2].append('#');
        }

        for (StringBuilder sb : result) {
            System.out.println(sb);
        }
    }
}
