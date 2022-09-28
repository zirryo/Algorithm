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
        int sum = 0;
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        while(N-- > 0) {
            sum += Integer.parseInt(st.nextToken()) % M;
            arr[sum%M]++;
        }

        long result = arr[0]; // M으로 나누어 떨어지는 경우, 구간 크기 1
        for(int i=0; i<M; i++) {
            int k = arr[i];
            result += (long)k * (k-1) / 2; // 순서 구분없이 나머지가 같은 수 2개 고르기
        }
        System.out.println(result);
    }
}