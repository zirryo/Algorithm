import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 2L; // 최고차항, =
        String s;
        int numLen;
        int x;


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            s = st.nextToken();

            if (i == 0) continue;

            numLen = s.length();
            x = Integer.parseInt(s);

            if (i == N) {
                if (x != 0) result += (numLen + 1);
            } else {
                if (x == 0) result += 2;
                else result += (numLen + 3);
            }
        }

        System.out.println(result);
    }
}
///
