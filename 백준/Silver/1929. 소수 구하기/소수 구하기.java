import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] notPrime;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        notPrime = new boolean[N+1];

        prime();
        StringBuilder sb = new StringBuilder();

        for(int i=M; i<=N; i++) {
            if(!notPrime[i]) sb.append(i + "\n");
        }
        System.out.println(sb);
    }
    // 에라토테네스의 체를 이용하여 소수 판별
    static void prime() {
        notPrime[0] = true;
        notPrime[1] = true;

        for(int i=2; i <=Math.sqrt(N); i++) {
            if(notPrime[i]) continue;
            for(int j = i*i; j<=N; j += i) {
                notPrime[j] = true;
            }
        }
    }
}
