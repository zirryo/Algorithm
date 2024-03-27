import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            boolean allZero = true;
            boolean hasOdd = false;

            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 1) {
                    hasOdd = true;
                    arr[i]--;
                    result++;
                }

                if (arr[i] != 0) allZero = false;
            }

            if (allZero) break;
            if (!hasOdd) {
                result++;
                for (int i = 0; i < N; i++) {
                    arr[i] /= 2;
                }
            }
        }

        System.out.println(result);
    }
}