import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = arr[N-1];

        for (int i = N - 1; i >= 0; i--) {
            int cur = arr[i] * (N - i);
            if (max <= cur) {
                max = cur;
            } 
        }

        System.out.println(max);
    }
}