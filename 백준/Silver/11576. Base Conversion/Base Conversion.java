import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] aDigits = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            aDigits[i] = Integer.parseInt(st.nextToken());
        }

        int decimalValue = 0;
        for (int i = 0; i < m; i++) {
            decimalValue = decimalValue * A + aDigits[i];
        }

        ArrayList<Integer> bDigits = new ArrayList<>();
        while (decimalValue > 0) {
            bDigits.add(decimalValue % B);
            decimalValue /= B;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bDigits.size() - 1; i >= 0; i--) {
            sb.append(bDigits.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
