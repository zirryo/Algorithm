import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int R = 0;
        int B = 0;
        char[] chars = br.readLine().toCharArray();
        
        for (char c : chars) {
            if (c == 'R') R++;
        }
        
        B = N - R;
        int result = Math.min(R, B);
        int seq = 0;

        for (int i = 0; i < N; i++) {
            if (chars[0] == chars[i]) seq++;
            else break;
        }

        if (chars[0] == 'R') result = Math.min(result, R - seq);
        else result = Math.min(result, B - seq);

        seq = 0;
        for (int i = N-1; i > 0; i--) {
            if (chars[N-1] == chars[i]) seq++;
            else break;
        }

        if (chars[N-1] == 'R') result = Math.min(result, R - seq);
        else result = Math.min(result, B - seq);

        System.out.println(result);
    }
}