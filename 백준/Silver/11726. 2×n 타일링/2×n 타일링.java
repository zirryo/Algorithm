import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 10007;
    static int[] arr = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;
        fibo(N);
        System.out.println(arr[N]);
    }
    static int fibo(int n) {
        if(arr[n]>0) return arr[n];
        else return arr[n] = (fibo(n-1) + fibo(n-2))%MOD;
    }
}