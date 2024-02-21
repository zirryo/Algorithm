import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] res = pizzaOven(N);
            for (int j : res) sb.append(j).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[] pizzaOven(int x) {
        int[] ans = new int[5]; // +60, +10, -10, +1, -1

        ans[0] = x / 60;
        x %= 60;

        if (x > 35) {
            ans[0]++;
            ans[2] = 6 - (x / 10);

            if (x % 10 >= 5) {
                ans[2]--;
                ans[4] = 10 - x % 10;
            } else {
                ans[3] = x % 10;
            }
        } else {
            ans[1] = x / 10;

            if (x % 10 > 5) {
                ans[1]++;
                ans[4] = 10 - x % 10;
            } else {
                ans[3] = x % 10;
            }
        }

        return ans;
    }
}