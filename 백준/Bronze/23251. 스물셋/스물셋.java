import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String kStr = br.readLine();
            BigInteger k = new BigInteger(kStr);
            System.out.println(k.multiply(new BigInteger("23")));
        }
    }
}