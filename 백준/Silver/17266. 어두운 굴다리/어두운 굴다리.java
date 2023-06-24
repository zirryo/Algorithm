import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int pre = len;
        int x = len;

        for (int i=1; i<K; i++) {
            x = Integer.parseInt(st.nextToken());
            int temp = (x - pre + 1) / 2;
            if (temp > len) len = temp;
            pre = x;
        }
        len = Math.max(len, N - x);
        System.out.println(len);
    }
}