import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int l = 0;
        int r = 0;
        int sum = 0;

        while (r <= N) {
            if (sum >= M) {
                sum -= arr[l++];
            } else if (r == N) {
                break;
            } else {
                sum += arr[r++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
