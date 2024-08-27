import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String[] names = new String[n+1];
            int[] rings = new int[n+1];
            for (int i = 1; i <= n; i++) {
                names[i] = br.readLine();
            }
            for (int i = 1; i < 2 * n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                rings[x]++;
            }
            sb.append(num).append(" ");
            for (int i = 1; i <= n; i++) {
                if (rings[i] == 1) {
                    sb.append(names[i]).append("\n");
                    break;
                }
            }
            num++;
        }
        System.out.println(sb);
    }
}
