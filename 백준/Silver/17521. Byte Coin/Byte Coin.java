import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        long money = Integer.parseInt(st.nextToken());
        long coin = 0;

        int[] price = new int[day+1];
        for (int i = 1; i <= day; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < day; i++) {
            if (coin == 0 && price[i] < price[i+1]) {
                coin = money / price[i];
                money -= coin * price[i];
            } else if (coin > 0 && price[i] > price[i+1]) {
                money += coin * price[i];
                coin = 0;
            }
        }

        money += coin * price[day];
        System.out.println(money);
    }
}
