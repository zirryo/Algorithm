import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        long result = Math.abs(arr[left] + arr[right]);

        int tempL = left;
        int tempR = right;

        while(tempL<tempR) {
            long tempResult = arr[tempL] + arr[tempR];

            if(Math.abs(tempResult) < result) {
                left = tempL;
                right = tempR;
                result = Math.abs(tempResult);

                if(result == 0) break;
            }

            if(tempResult > 0) tempR--;
            else tempL++;
        }
        System.out.println(arr[left] + " " + arr[right]);
    }

}