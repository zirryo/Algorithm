import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum /= 2;
        int tempSum = 0;
        for (int i = 0; i < N-1; i += 2) {
            tempSum += arr[i];
        }

        int diff = sum - tempSum;
        int[] result = new int[N];
        result[N-1] = diff;
        for (int i = N-2; i >= 0; i--) {
            result[i] = arr[i] - result[i+1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
