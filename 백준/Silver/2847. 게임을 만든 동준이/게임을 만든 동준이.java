import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        int prev;
        for (int i = N-2; i >= 0; i--) {
            prev = arr[i+1];
            if (arr[i] >= prev) {
                int diff = arr[i] - prev + 1;
                arr[i] -= diff;
                result += diff;
            }
        }
        System.out.println(result);
    }
}