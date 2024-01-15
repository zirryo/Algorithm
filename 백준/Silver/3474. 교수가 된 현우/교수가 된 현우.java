import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            long cnt = 0L;

            while (X >= 5) {
                cnt += (X / 5);
                X /= 5;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}