import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cows);

        int left = 0;
        int right = N - 1;
        int count = 0;

        while (left < right) {
            if (cows[left] + cows[right] <= S) {
                count += (right - left);
                left++;
            } else {
                right--; 
            }
        }

        System.out.println(count);
    }
}
