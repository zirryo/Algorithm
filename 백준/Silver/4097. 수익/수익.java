import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] arr;
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int cur = arr[0];
            int max = arr[0];
            for (int i=1; i<N; i++) {
                cur = Math.max(arr[i], cur + arr[i]);
                max = Math.max(max, cur);
            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}