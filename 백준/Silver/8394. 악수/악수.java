import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int prev2 = 1;
        int prev1 = 2;

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(2);
            return;
        }

        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % 10;
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(current % 10);
    }
}
