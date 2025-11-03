import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] arr = br.readLine().split(" ");
            String a = arr[0];
            String b = arr[1];

            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            StringBuilder res = new StringBuilder();

            while (i >= 0 || j >= 0 || carry > 0) {
                int sum = carry;

                if (i >= 0) sum += a.charAt(i--) - '0';
                if (j >= 0) sum += b.charAt(j--) - '0';

                res.append(sum % 2);
                carry = sum / 2;
            }

            res.reverse();

            int idx = 0;
            while (idx < res.length() - 1 && res.charAt(idx) == '0') {
                idx++;
            }
            sb.append(res.substring(idx)).append("\n");
        }

        System.out.print(sb);
    }
}
