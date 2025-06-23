import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int scenario = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            String[] tunes = new String[n];
            for (int i = 0; i < n; i++) {
                tunes[i] = br.readLine();
            }

            Arrays.sort(tunes, String.CASE_INSENSITIVE_ORDER);

            System.out.println(scenario++);
            for (String tune : tunes) {
                System.out.println(tune);
            }
        }
    }
}
