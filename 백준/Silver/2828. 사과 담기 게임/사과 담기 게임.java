import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int l = 1;
        int r = M;
        int result = 0;
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < K; i++) {
            if (arr[i] > r) {
                int move = arr[i] - r;
                r = arr[i];
                l += move;
                result += move;
            } else if (arr[i] < l) {
                int move = l - arr[i];
                l = arr[i];
                r -= move;
                result += move;
            }
        }
        System.out.println(result);
    }
}
