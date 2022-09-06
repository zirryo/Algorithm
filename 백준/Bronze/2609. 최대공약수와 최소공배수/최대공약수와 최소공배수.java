import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int gcd = getGCD(N,M);

        System.out.println(gcd);
        System.out.println(N * M / gcd);

    }
    static int getGCD(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        if(max%min == 0) return min;
        return getGCD(max%min,min);
    }
}
