import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);

        int t = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = t; i < n - t; i++) {
            sum += scores[i];
        }

        int count = n - 2 * t;
        int result = (int) Math.round((double) sum / count);

        System.out.println(result);
    }
}
