import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
        long muscleLoss = arr[0];

        if (N % 2 == 0) {
            for (int i = 0; i < N/2; i++) {
                muscleLoss = Math.max(muscleLoss, arr[i] + arr[N-1-i]);
            }
        } else {
            for (int i = 0; i < N/2; i++) {
                muscleLoss = Math.max(muscleLoss, arr[i] + arr[N-2-i]);
            }
            muscleLoss = Math.max(muscleLoss, arr[N-1]);
        }

        System.out.println(muscleLoss);
    }
}