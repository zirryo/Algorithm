import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] customers = new int[N][2]; // {지불 가능 금액, 배송비}
        int maxPrice = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxPay = Integer.parseInt(st.nextToken());
            int deliveryFee = Integer.parseInt(st.nextToken());
            customers[i] = new int[]{maxPay, deliveryFee};

            maxPrice = Math.max(maxPrice, maxPay);
        }

        int maxProfit = 0;
        int bestPrice = 0;

        for (int price = 0; price <= maxPrice; price++) {
            int profit = 0;

            for (int[] customer : customers) {
                int maxPay = customer[0];
                int deliveryFee = customer[1];

                if (maxPay >= price) {
                    int individualProfit = price - deliveryFee;
                    if (individualProfit > 0) {
                        profit += individualProfit;
                    }
                }
            }

            if (profit > maxProfit || (profit == maxProfit && price < bestPrice)) {
                maxProfit = profit;
                bestPrice = price;
            }
        }

        System.out.println(bestPrice);
    }
}
