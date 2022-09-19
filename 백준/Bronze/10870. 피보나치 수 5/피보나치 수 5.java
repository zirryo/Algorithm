import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[21];
        System.out.println(fibo(N));

    }
    static int fibo(int N) {
        if(N<=1) return arr[N] = N;
        if(arr[N] != 0) return arr[N];
        return arr[N] = fibo(N-1) + fibo(N-2);
    }
}