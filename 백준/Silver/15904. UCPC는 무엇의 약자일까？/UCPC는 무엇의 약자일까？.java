import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (containsUCPC(input)) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }

    public static boolean containsUCPC(String str) {
        char[] target = {'U', 'C', 'P', 'C'};
        int index = 0;

        for (char ch : str.toCharArray()) {
            if (ch == target[index]) {
                index++;
                if (index == 4) return true;
            }
        }

        return false;
    }
}
