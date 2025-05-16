import java.io.*;
import java.util.*;

public class Main {
    static class Hand {
        int height;
        int personId;

        Hand(int height, int personId) {
            this.height = height;
            this.personId = personId;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int total = M * 2;

        List<Hand> hands = new ArrayList<>();
        hands.add(new Hand(0, 0));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            hands.add(new Hand(h1, i));
            hands.add(new Hand(h2, i));
        }

        hands.sort(Comparator.comparingInt(h -> h.height));
        int resFloor = N % total == 0 ? total : N % total;

        System.out.println(hands.get(resFloor).personId);
    }
}
