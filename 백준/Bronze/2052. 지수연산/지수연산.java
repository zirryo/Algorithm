import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger tenPow = BigInteger.TEN.pow(N);
        BigInteger twoPow = BigInteger.valueOf(2).pow(N);
        BigInteger numerator = tenPow.divide(twoPow);

        String numStr = numerator.toString();

        StringBuilder sb = new StringBuilder();
        if (numStr.length() <= N) {
            sb.append("0.");
            for (int i = numStr.length(); i < N; i++) {
                sb.append("0");
            }
            sb.append(numStr);
        } else {
            int pointPos = numStr.length() - N;
            sb.append(numStr.substring(0, pointPos))
                    .append(".")
                    .append(numStr.substring(pointPos));
        }
        
        String result = sb.toString();
        while (result.endsWith("0")) {
            result = result.substring(0, result.length() - 1);
        }
        if (result.endsWith(".")) {
            result = result.substring(0, result.length() - 1);
        }

        System.out.println(result);
    }
}
