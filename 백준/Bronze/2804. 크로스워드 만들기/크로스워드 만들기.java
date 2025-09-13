import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int col = -1, row = -1;

        outer:
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    col = i;
                    row = j;
                    break outer;
                }
            }
        }


        for (int i = 0; i < B.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length(); j++) {
                if (i == row) {
                    sb.append(A.charAt(j));
                } else if (j == col) {
                    sb.append(B.charAt(i));
                } else {
                    sb.append('.');
                }
            }
            System.out.println(sb);
        }
    }
}
