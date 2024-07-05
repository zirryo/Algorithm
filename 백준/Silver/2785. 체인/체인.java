import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] chains = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chains[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chains);
        int totalChains = N;
        int result = 0;
        int idx = 0;

        while (totalChains > 1 && idx < chains.length) {
            chains[idx]--;
            totalChains--;
            result++;
            if (chains[idx] == 0) {
                idx++;
                totalChains--;
            }
        }

        System.out.println(result);
    }
}
