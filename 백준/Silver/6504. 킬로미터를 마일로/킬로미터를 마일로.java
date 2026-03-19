import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> fibo = new ArrayList<>();
        fibo.add(1);
        fibo.add(2);
        while (true) {
            int next = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
            if (next > 30000) break;
            fibo.add(next);
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int k = fibo.size();
            int[] bits = new int[k];
            int tempX = x;

            for (int i = k - 1; i >= 0; i--) {
                if (tempX >= fibo.get(i)) {
                    bits[i] = 1;
                    tempX -= fibo.get(i);
                }
            }

            long y = 0;
            for (int i = 1; i < k; i++) {
                if (bits[i] == 1) {
                    y += fibo.get(i - 1);
                }
            }
            sb.append(y).append("\n");
        }
        System.out.print(sb);
    }
}