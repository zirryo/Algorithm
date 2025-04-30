import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int min = price[0];
        int maxProfit = 0;

        for (int i = 1; i < N; i++) {
            maxProfit = Math.max(maxProfit, price[i] - min);
            min = Math.min(min, price[i]);
        }

        System.out.println(maxProfit);
    }
}
