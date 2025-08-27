import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Y = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long result = (Y - 2015) * 4;

        if (M < 3) {
            result += 1;
        } else if (M < 6) {
            result += 2;
        } else if (M < 9) {
            result += 3;
        } else if (M < 12) {
            result += 4;
        } else {
            result += 5;
        }

        System.out.println(result);
    }
}
