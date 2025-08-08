import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long left = 0;
        long right = 0;

        while (a != 1 && b != 1) {
            if (a > b) {
                long times = a / b;
                left += times;
                a %= b;
            } else {
                long times = b / a;
                right += times;
                b %= a;
            }
        }


        if (a == 1) {
            right += b - 1;
        } else {
            left += a - 1;
        }

        System.out.println(left + " " + right);
    }
}
