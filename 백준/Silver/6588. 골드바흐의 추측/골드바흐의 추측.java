import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] notPrime = new boolean[1000001];
    static final String fail = "Goldbach's conjecture is wrong.";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrime();

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int a = 1;
            int b = N-1;

            while(a<=b) {
                if(!notPrime[a] && !notPrime[b]) {
                    sb.append(N).append(" = "+ a + " + " + b + "\n");
                    break;
                } else if(a==b) {
                    sb.append(fail).append("\n");
                    break;
                }
                a++;
                b--;
            }
        }

        System.out.println(sb);
    }
    static void getPrime() {
        notPrime[0] = true;
        notPrime[1] = true;

        for(int i=2; i <= Math.sqrt(notPrime.length); i++) {
            if(notPrime[i]) continue;
            for(int j = i*i; j< notPrime.length; j +=i) {
                notPrime[j] = true;
            }
        }
    }
}