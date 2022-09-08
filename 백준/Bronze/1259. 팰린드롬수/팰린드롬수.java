import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            String N = br.readLine();
            if(N.equals("0")) break;

            if(palindrome(N)) sb.append("yes" + "\n");
            else sb.append("no" + "\n");

        }
        System.out.println(sb);


    }
    static boolean palindrome(String n) {
        int left = 0;
        int right = n.length()-1;

        if(right%2==0) { // 수 길이 홀수
            while(true) {
                if(left==right) {
                    return true;
                }
                if(n.charAt(left) != n.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        else { // 수 길이 홀수
            while(true) {
                if(left>right) {
                    return true;
                }
                if(n.charAt(left) != n.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
    }
}