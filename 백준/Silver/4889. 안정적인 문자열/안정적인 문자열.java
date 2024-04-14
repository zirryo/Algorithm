import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '-') break;
            int cnt = 0;
            int open = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '{') {
                    open++;
                } else {
                    if (open == 0) {
                        cnt++;
                        open++;
                    } else {
                        open--;
                    }
                }
            }
            cnt += open / 2;
            sb.append(String.format("%d. %d\n", num, cnt));
            num++;
        }
        System.out.println(sb);
    }
}