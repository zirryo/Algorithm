import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] P;
    static int[] S;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = i;
        }

        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(cards));
        int shuffleCount = 0;
        while (true) {
            if (checkTarget()) {
                System.out.println(shuffleCount);
                return;
            }
            cards = shuffle(cards);
            String state = Arrays.toString(cards);
            if (visited.contains(state)) {
                System.out.println(-1);
                return;
            }


            visited.add(state);
            shuffleCount++;
        }
    }

    private static boolean checkTarget() {
        for (int i = 0; i < N; i++) {
            if (cards[i] % 3 != P[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] shuffle(int[] arr) {
        int[] newCards = new int[N];
        for (int i = 0; i < N; i++) {
            newCards[i] = arr[S[i]];
        }
        return newCards;
    }
}