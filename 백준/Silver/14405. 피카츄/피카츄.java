import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.matches("^(pi|ka|chu)+$")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
