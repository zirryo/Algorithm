import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        int maxCard = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            if (card[i] > maxCard) {
                maxCard = card[i];
            }
        }

        int[] score = new int[maxCard + 1];
        boolean[] validCard = new boolean[maxCard + 1];

        for (int x : card) {
            validCard[x] = true;
        }

        for (int i = 0; i < N; i++) {
            int cur = card[i];
            for (int j = cur * 2; j <= maxCard; j += cur) {
                if (validCard[j]) {
                    score[j]--;
                    score[cur]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : card) {
            if (validCard[i]) sb.append(score[i] + " ");
        }
        System.out.println(sb);
    }
}