import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            boolean result = validPS(s);

            if(result) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean validPS(String s) {
        while(s.contains("()")) {
            s = s.replaceAll("\\(\\)", "");
        }
        return (s.length() == 0);
    }
}