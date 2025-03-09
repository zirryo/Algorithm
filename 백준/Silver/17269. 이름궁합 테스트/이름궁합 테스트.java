import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lenA = Integer.parseInt(st.nextToken());
        int lenB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int[] letterValues = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(lenA, lenB);
        for (int i = 0; i < minLength; i++) {
            sb.append(A.charAt(i)).append(B.charAt(i));
        }
        if (lenA > lenB) sb.append(A.substring(minLength));
        else sb.append(B.substring(minLength));
        String combined = sb.toString();

        int[] values = new int[combined.length()];
        for (int i = 0; i < combined.length(); i++) {
            values[i] = letterValues[combined.charAt(i) - 'A'];
        }

        while (values.length > 2) {
            int[] temp = new int[values.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (values[i] + values[i + 1]) % 10;
            }
            values = temp;
        }

        if (values[0] == 0) {
            System.out.println(values[1] + "%");
        } else {
            System.out.println(values[0] + "" + values[1] + "%");
        }

    }
}
