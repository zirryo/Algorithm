import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static final int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][K+1];
        System.out.println(nCr(N,K));


    }
    static int nCr(int n, int r) {
        if (arr[n][r] > 0) return arr[n][r];
        else if (n == r || r == 0) return arr[n][r] = 1;
        return arr[n][r] = (nCr(n - 1, r - 1) + nCr(n - 1, r)) % DIV;
    }
}