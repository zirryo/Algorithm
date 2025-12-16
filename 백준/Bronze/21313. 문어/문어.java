import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            sb.append(i % 2 == 1 ? 1 : 2);
            sb.append(" ");
        }

        if (N % 2 == 0) {
            sb.append(2);
        } else {
            sb.append(3);
        }

        System.out.println(sb.toString());
    }
}