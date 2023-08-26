import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int X = 1;
        int cnt = 0;
        int result = 0;

        while (K > X) {
            X *= 2;
            cnt++;
        }
        for (int i = 0; i < cnt; i++) {
            if ((K & (1 << i)) != 0) {
                result = cnt - i;
                break;
            }
        }
        System.out.println(X + " " + result);
    }
}