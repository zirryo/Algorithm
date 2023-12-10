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
        int[] arr = new int[M];
        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int price = 0;
        int total = 0;
        for (int i=0; i<M; i++) {
            int cur = arr[i];
            int sum = 0;
            if (M-i < N) {
                sum = cur * (M - i);
            } else {
                sum = cur * N;
            }

            if (sum > total) {
                total = sum;
                price = cur;
            }
        }

        System.out.println(price + " " + total);
    }
}