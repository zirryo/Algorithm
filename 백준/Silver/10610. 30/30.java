import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] digits = N.toCharArray();
        Arrays.sort(digits);

        int sum = 0;
        for (char c : digits) {
            sum += c - '0';
        }

        if (digits[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder(new String(digits));
            System.out.println(sb.reverse());
        }
    }
}
