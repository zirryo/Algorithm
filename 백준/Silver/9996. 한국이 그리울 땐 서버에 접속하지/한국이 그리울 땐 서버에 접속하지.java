import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String front = st.nextToken();
        String back = st.nextToken();
        int len = front.length() + back.length();

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            if (len > s.length() || !s.startsWith(front)) {
                sb.append("NE\n");
            } else {
                if (s.endsWith(back)) sb.append("DA\n");
                else sb.append("NE\n");
            }
        }
        System.out.println(sb);
    }
}