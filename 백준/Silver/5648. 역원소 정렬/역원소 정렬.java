import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<BigInteger> numbers = new ArrayList<>();

        while (st.hasMoreTokens()) {
            numbers.add(reverseNumber(st.nextToken()));
        }

        while (numbers.size() < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                numbers.add(reverseNumber(st.nextToken()));
            }
        }

        Collections.sort(numbers);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (BigInteger num : numbers) {
            bw.write(num.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static BigInteger reverseNumber(String num) {
        return new BigInteger(new StringBuilder(num).reverse().toString());
    }
}
