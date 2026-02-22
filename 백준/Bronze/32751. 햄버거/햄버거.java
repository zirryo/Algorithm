import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        String burger = br.readLine();

        if (burger.charAt(0) != 'a' || burger.charAt(N - 1) != 'a') {
            System.out.println("No");
            return;
        }

        int[] count = new int[4];

        for (int i = 0; i < N; i++) {
            char cur = burger.charAt(i);

            if (i > 0 && burger.charAt(i - 1) == cur) {
                System.out.println("No");
                return;
            }

            count[cur - 'a']++;
        }

        if (count[0] <= A && count[1] <= B && count[2] <= C && count[3] <= D) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}