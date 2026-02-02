import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] alcohol = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            alcohol[i] = Integer.parseInt(st.nextToken());
        }

        int currentSum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            currentSum += alcohol[i];

            if (i >= L) {
                currentSum -= alcohol[i - L];
            }

            if (currentSum >= 129 && currentSum <= 138) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}