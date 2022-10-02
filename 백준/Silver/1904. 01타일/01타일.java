import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[1] = 1;

        if(N>1) arr[2] = 2;
        fibo(N);
        System.out.println(arr[N]);

    }
    public static int fibo(int N) {
        if(arr[N] > 0) return arr[N];
        return arr[N] = (fibo(N-1) + fibo(N-2)) % 15746;
    }
}