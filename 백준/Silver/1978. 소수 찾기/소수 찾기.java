import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(N-->0) {
            int i = Integer.parseInt(st.nextToken());
            if(isPrime(i)) cnt++;
        }
        System.out.println(cnt);

    }
    static boolean isPrime(int n) {
        if(n==2) return true;
        if(n % 2 ==0 || n == 1) {
            return false;
        }
        for(int i=3; i<=Math.sqrt(n); i+=2) {
            if(n%i==0) return false;
        }
        return true;
    }
}