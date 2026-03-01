import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] cards = new String[n];
            for (int i = 0; i < n; i++) {
                cards[i] = br.readLine();
            }

            int mid = (n + 1) / 2;


            for (int i = 0; i < mid; i++) {
                sb.append(cards[i]).append("\n");

                if (i + mid < n) {
                    sb.append(cards[i + mid]).append("\n");
                }
            }

        }
        System.out.print(sb);
    }
}