import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            String s = br.readLine();
            sb.append(contact(s) ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }
    public static boolean contact(String str) {
        if(str.startsWith("01")) {
            if(str.length()==2) return true;
            else return contact(str.substring(2));
        } else if(str.matches("(100+1+(01)*)+")) return true;
        return false;
    }
}