import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 10001;

        int[] coin = new int[N];
        int[] ways = new int[K+1];

        Arrays.fill(ways, max);
        ways[0] = 0;

        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++) {
            for(int j=1; j<=K; j++) {
                if(coin[i] <= j) {
                    ways[j] = Math.min(ways[j], ways[j - coin[i]] + 1);
                }
            }
        }

        if(ways[K] == max) System.out.println("-1");
        else System.out.println(ways[K]);
    }

}