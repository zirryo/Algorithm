import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] t = new long[36];  
        t[0] = 1; 

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                t[i] += t[j] * t[i - j - 1];
            }
        }

        System.out.println(t[n]);
    }
}
