import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> bidCount = new HashMap<>();
        Map<Integer, String> firstBidder = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            bidCount.put(price, bidCount.getOrDefault(price, 0) + 1);

            firstBidder.putIfAbsent(price, name);
        }

        int minFrequency = Integer.MAX_VALUE;
        int winningPrice = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : bidCount.entrySet()) {
            int price = entry.getKey();
            int count = entry.getValue();

            if (count < minFrequency || (count == minFrequency && price < winningPrice)) {
                minFrequency = count;
                winningPrice = price;
            }
        }

        System.out.println(firstBidder.get(winningPrice) + " " + winningPrice);
    }
}
