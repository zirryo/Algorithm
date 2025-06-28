import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseNum = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            int fullPeriods = V / P;
            int remainderDays = V % P;

            int result = fullPeriods * L + Math.min(L, remainderDays);
            System.out.println("Case " + caseNum + ": " + result);
            caseNum++;
        }
    }
}
