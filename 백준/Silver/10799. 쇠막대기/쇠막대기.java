import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;
        int stick = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i+1) == ')') {
                    result += stick;
                    i++;
                } else {
                    result++;
                    stick++;
                }
            } else {
                stick--;
            }
        }

        System.out.println(result);
    }
}