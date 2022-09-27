import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            temp[i] = temp[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i=K; i<=N; i++) {
            max = Math.max(max, temp[i]-temp[i-K]);
        }
        System.out.println(max);
    }
}