import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        char first = 0;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            char c = s.charAt(0);
            if (i == 0) first = c;
            else if (c != first) flag = false;
        }
        System.out.println(flag ? 1 : 0);
    }
}
