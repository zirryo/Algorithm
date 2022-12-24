import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-->0) {
            String s = br.readLine();

            int len = s.length()-1;

            sb.append(palindrome(s, 0, len, 0)).append("\n");
        }
        System.out.println(sb);
    }
    
    private static int palindrome(String s, int ldx, int rdx, int val) {
        if(val == 2) return 2;

        int result = val;

        while(ldx<=rdx) {
            if (s.charAt(ldx) == s.charAt(rdx)) {
                ldx++;
                rdx--;
            } else {
                int removeLeft = palindrome(s, ldx+1, rdx, val+1);
                int removeRight = palindrome(s, ldx, rdx-1, val+1);

                result = Math.min(removeLeft, removeRight);
                break;
            }
        }
        
        return result;
    }
}