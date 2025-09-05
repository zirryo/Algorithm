import java.io.*;
import java.util.*;

public class Main {
    static String[] codes = {
            "000000", "001111", "010011", "011100",
            "100110", "101001", "110101", "111010"
    };
    static char[] letters = {'A','B','C','D','E','F','G','H'};
    
    static int hamming(String a, String b) {
        int diff = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); 
        String s = br.readLine().trim(); 
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String part = s.substring(i*6, (i+1)*6);
            boolean found = false;

            for (int j = 0; j < 8; j++) {
                int d = hamming(part, codes[j]);
                if (d == 0 || d == 1) {
                    result.append(letters[j]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(i+1); 
                return;
            }
        }

        System.out.println(result.toString());
    }
}
