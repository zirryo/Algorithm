import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N-1;
        int result = 200_000_001;
        int sum;

        while (l < r) {
            sum = arr[l] + arr[r];
            if (Math.abs(sum) < Math.abs(result)) {
                result = sum;
            }
            if (result == 0) break;

            if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }

        System.out.println(result);
    }
}