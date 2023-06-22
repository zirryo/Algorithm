import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int inputLimit = 1000001;
        long[] fx = new long[inputLimit];
        long[] gx = new long[inputLimit];
        Arrays.fill(fx, 1L);
        gx[1] = 1;

        for (int i=2; i<inputLimit; i++) {
            for (int j=1; i*j < inputLimit; j++) {
                fx[i * j] += i;
            }
            gx[i] = gx[i-1] + fx[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int X = Integer.parseInt(br.readLine());
            sb.append(gx[X]).append("\n");
        }
        System.out.println(sb);
    }
}