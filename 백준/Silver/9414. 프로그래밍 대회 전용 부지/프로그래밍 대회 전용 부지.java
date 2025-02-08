import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    static final int PRICE_LIMIT = 5 * 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            List<Integer> price = new ArrayList<>();
            while (true) {
                int x = Integer.parseInt(br.readLine());
                if (x == 0) break;
                price.add(x);
            }
            Collections.sort(price, Collections.reverseOrder());

            int sum = 0;
            for (int i = 0; i < price.size(); i++) {
                sum += (int) Math.pow(price.get(i), i + 1) * 2;
                if (sum > PRICE_LIMIT) break;
            }

            if (sum > PRICE_LIMIT) sb.append("Too expensive\n");
            else sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}