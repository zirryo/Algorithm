import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long result = 0L;
        for (int i = 0; i < N - 1; i++) {
            result += binarySearch(i) - i;
        }
        System.out.println(result);

    }
    private static int binarySearch(int i) {
        int l = i + 1;
        int r = N - 1;
        int ans = i;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[i] * 10 >= arr[mid] * 9) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}