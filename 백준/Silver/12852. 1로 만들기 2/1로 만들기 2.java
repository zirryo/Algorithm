import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int N;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solve();
        System.out.println(result);
    }
    private static void solve() {
        int[] count = new int[N+1];
        int[] path = new int[N+1]; // 특정 인덱스에 도달하기 직전 위치 저장
        Arrays.fill(count, N);
        count[1] = 0;

        for(int i=2; i<=N; i++) {
            if(i%3 == 0 && count[i] > count[i/3] + 1) {
                count[i] = count[i/3] + 1;
                path[i] = i / 3;
            }
            if(i%2 == 0 && count[i] > count[i/2] + 1) {
                count[i] = count[i/2] + 1;
                path[i] = i / 2;
            }
            if(count[i] > count[i-1] + 1) {
                count[i] = count[i-1] + 1;
                path[i] = i - 1;
            }
        }
        result.append(count[N]).append("\n");

        while(N > 0) {
            result.append(N).append(" ");
            N = path[N];
        }
    }
}