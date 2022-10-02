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
        arr[1] = arr[2] = 1;
        fibo(N);
        sb.append(arr[N] + " " + (N-2));
        System.out.println(sb);
    }
    public static int fibo(int N) {
        if(arr[N] > 0) return arr[N];
        return arr[N] = fibo(N-1) + fibo(N-2);
    }
}