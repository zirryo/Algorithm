import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine().trim();
        
        char[] digits = num.toCharArray();
        Arrays.sort(digits); 
        StringBuilder sb = new StringBuilder(new String(digits));
        System.out.println(sb.reverse().toString());
    }
}
