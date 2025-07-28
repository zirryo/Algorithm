import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] T = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(T);

        long totalTaste = T[N-1];
        K--;

        int l = 0;
        int r = N-2;

        while (l < r && K >= 2) {
            totalTaste += (T[r] - T[l]);
            l++;
            r--;
            K -= 2;
        }

        sb.append(totalTaste).append("\n");
        System.out.print(sb);
    }
}
