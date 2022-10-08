import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long min = 0;
        long mid = 0;
        long max = 0;

        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        max++; // 초기화 이후 mid = 0 이 되는것을 방지하기 위해 max + 1

        while(min < max) {
            mid = (min + max) / 2;
            long cnt = 0;
            for(int i : arr) {
                cnt += (i / mid);
            }

            if(cnt < K) max = mid;
            else min = mid + 1;
        }
        System.out.println(min -1);
    }
}
