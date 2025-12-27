import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        List<String> ops = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (cards[i] == i) continue;

            int pos = i;
            for (int j = i + 1; j <= N; j++) {
                if (cards[j] == i) {
                    pos = j;
                    break;
                }
            }

            reverse(cards, i, pos);
            ops.add(i + " " + pos);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ops.size()).append("\n");
        for (String op : ops) {
            sb.append(op).append("\n");
        }
        System.out.print(sb);
    }

    static void reverse(int[] arr, int L, int R) {
        while (L < R) {
            int temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
            L++;
            R--;
        }
    }
}