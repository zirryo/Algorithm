import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static long DIV = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long facN = factorial(N);
        long denom = factorial(K) * factorial(N-K) % DIV;
        System.out.println(facN * pow(denom, DIV-2) % DIV);
    }
    public static long factorial(long N) {
        long l = 1L;
        while(N>1) {
            l = (l * N) % DIV;
            N--;
        }
        return l;
    }
    public static long pow(long base, long exp) {
        if(exp == 1) return base % DIV;
        long temp = pow(base, exp/2);

        if(exp % 2 == 1) return (temp * temp % DIV) * base % DIV;
        return temp * temp % DIV;
    }
}
