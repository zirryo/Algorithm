import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count0 = 0;
        int count1 = 0;
        
        if (s.charAt(0) == '0') count0++;
        else count1++;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (s.charAt(i) == '0') count0++;
                else count1++;
            }
        }
        
        System.out.println(Math.min(count0, count1));
    }
}
