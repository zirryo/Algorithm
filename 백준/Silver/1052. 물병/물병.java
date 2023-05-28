import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;

        while(Integer.bitCount(n) > k) {
            result += n & (-n);
            n += n & (-n);
            // n & (-n) : n을 이진수로 표현했을 때 가장 오른쪽에 있는 1
        }

        System.out.println(result);
    }
}