import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long tips = 0;
        int order = 0;

        for (int i = N-1; i >= 0; i--) {
            int tip = arr[i] - order;
            if (tip > 0) tips += tip;
            order++;
        }
        System.out.println(tips);
    }
}