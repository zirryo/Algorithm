import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        char[] sequence = {'H', 'O', 'N', 'I'};
        int state = 0;
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == sequence[state]) {
                state++;
                if (state == 4) {
                    count++;
                    state = 0;
                }
            }
        }

        System.out.println(count);
    }
}
