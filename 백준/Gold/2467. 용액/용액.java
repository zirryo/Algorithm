import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 0;
        int hi = N-1;
        int tempL = lo;
        int tempH = hi;

        long result = Math.abs(arr[lo] + arr[hi]);

        while (tempL < tempH) {
            long tempResult = arr[tempL] + arr[tempH];

            if (Math.abs(tempResult) < result) {
                lo = tempL;
                hi = tempH;
                result = Math.abs(tempResult);

                if (result == 0) break;
            }

            if (tempResult > 0) tempH--;
            else tempL++;
        }

        System.out.println(arr[lo] + " " + arr[hi]);
    }
}