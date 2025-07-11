import java.util.*;
import java.io.*;

public class Main {
    static class Card {
        int owner, value;

        Card(int owner, int value) {
            this.owner = owner;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, K;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Card> deck = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int val = Integer.parseInt(st.nextToken());
                deck.add(new Card(i, val));
            }
        }

        int currentIndex = 0;

        while (deck.size() > 1) {
            Card currentCard = deck.remove(currentIndex);
            int move = currentCard.value;
            int size = deck.size();
            currentIndex = (currentIndex + move - 1) % size;
        }

        Card winner = deck.get(0);
        System.out.println(winner.owner + " " + winner.value);
    }
}
