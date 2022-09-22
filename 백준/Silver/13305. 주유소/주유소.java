import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dis = new long[N-1];
        long[] price = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            dis[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }
        long sum = 0;
        long minPrice = price[0];

        for(int i=0; i<N-1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            sum += dis[i] * minPrice;
        }
        System.out.println(sum);
    }
}