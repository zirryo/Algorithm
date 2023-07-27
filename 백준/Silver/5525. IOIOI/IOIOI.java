import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int result = 0;

        for (int i = 0; i < M; i++) {
            if (s.charAt(i) == 'O') continue;
            int cnt = 0;
            while (i < M-1 && s.charAt(i) != s.charAt(i+1)) {
                i++;
                cnt++;
            }
            cnt /= 2;
            if (cnt < N) continue;
            result += (cnt - N + 1);
        }
        System.out.println(result);
    }
}
