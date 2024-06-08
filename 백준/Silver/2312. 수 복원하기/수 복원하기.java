import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            factorize(n);
        }

        System.out.print(sb.toString());
    }

    private static void factorize(int n) {
        int number = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int count = 0;
            while (number % i == 0) {
                count++;
                number /= i;
            }
            if (count > 0) {
                sb.append(i).append(" ").append(count).append("\n");
            }
        }
        if (number > 1) {
            sb.append(number).append(" 1").append("\n");
        }
    }
}