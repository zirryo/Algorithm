import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] zero = new int[41];
    public static int[] one = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        zero[0] = 1; // zero[1] = 0;
        one[1] = 1; // one[0] = 0;

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fiboZero(N) + " " + fiboOne(N) + "\n");
        }
        System.out.println(sb);
    }
    public static int fiboZero(int N) {
        if(N < 2 || zero[N] > 0) return zero[N];
        return zero[N] = fiboZero(N-1) + fiboZero(N-2);
    }
    public static int fiboOne(int N) {
        if(N < 2 || one[N] > 0) return one[N];
        return one[N] = fiboOne(N-1) + fiboOne(N-2);
    }
}