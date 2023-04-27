import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String m  = br.readLine();
        int ans = 0;
        for(int i=0; i<=n.length()- m.length(); i++) {
            boolean flag = true;
            for(int j=0; j<m.length(); j++) {
                if(n.charAt(i+j) != m.charAt(j)) {
                    flag = false;
                    continue;
                }
            }
            if(flag) {
                i += (m.length()-1);
                ans++;
            }
        }
        System.out.println(ans);
    }
}