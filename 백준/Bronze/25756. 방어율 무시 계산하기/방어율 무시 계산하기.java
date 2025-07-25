import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double current = 0.0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            double rate = a / 100.0;
            current = 1 - (1 - current) * (1 - rate);
            sb.append(String.format("%.10f\n", current * 100));
        }

        System.out.print(sb);
    }
}
