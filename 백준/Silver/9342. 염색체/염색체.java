import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");

        while (T-- > 0) {
            boolean result = checkString(br.readLine());

            if (result) sb.append("Infected!\n");
            else sb.append("Good\n");
        }

        System.out.println(sb);
    }
    private static boolean checkString(String input) {
        String pattern = "[A-F]?A+F+C+[A-F]?$";
        return Pattern.matches(pattern, input);
    }
}