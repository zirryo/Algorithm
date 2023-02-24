import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        init();

        int lo = 0;
        int hi = N-1;
        int result = 0;

        while(lo < hi) {
            if(arr[lo] + arr[hi] == M) {
                hi--;
                result++;
            } else {
                if(arr[lo] + arr[hi] < M) lo++;
                else hi--;
            }
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
    }
}