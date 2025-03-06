import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = K - 1; i < N; i++) {
            sb.append(input[i]);
        }

        if ((N-K+1) % 2 == 0) {
            for (int i = 0; i <= K-2; i++) {
                sb.append(input[i]);
            }
        } else {
            for (int i = K - 2; i >= 0; i--) {
                sb.append(input[i]);
            }
        }
        
        System.out.println(sb);
    }
}