import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine().trim());
        long n = k - 1L;                          
        int parity = Long.bitCount(n) & 1;     
        System.out.println(parity == 0 ? '0' : '1');
    }
}
