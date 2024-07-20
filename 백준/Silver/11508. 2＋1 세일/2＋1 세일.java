import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices);

        int totalCost = 0;
        for (int i = N - 1; i >= 0; i -= 3) {
            totalCost += prices[i];
            if (i - 1 >= 0) {
                totalCost += prices[i - 1];
            }
        }

        System.out.println(totalCost);
    }
}
