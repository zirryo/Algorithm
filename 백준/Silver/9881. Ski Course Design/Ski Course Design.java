import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int result = 100 * 100 * 1000;

        for (int l = arr[0]; l <= Math.min(83, arr[N-1]); l++) {
            int r = l + 17;
            int cost = 0;
            
            for (int x : arr) {
                if (x < l) {
                    cost += (l - x) * (l - x);
                } else if (x > r) {
                    cost += (r - x) * (r - x);
                }
            }

            result = Math.min(result, cost);
        }

        System.out.println(result);

    }
}
