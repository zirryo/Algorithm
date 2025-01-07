import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean isPossible = true;

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] books = new int[k];
            for (int j = 0; j < k; j++) {
                books[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < k - 1; j++) {
                if (books[j] < books[j + 1]) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) break;
        }

        System.out.println(isPossible ? "Yes" : "No");
    }
}