import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = L;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int l = 1;
        int r = L-1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = 0;

            for (int i = 1; i < arr.length; i++) {
                sum += (arr[i] - arr[i-1] - 1) / mid;
            }

            if (sum > M) l = mid + 1;
            else r = mid - 1;
        }
        System.out.println(l);
    }
}