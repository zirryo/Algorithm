import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("Case ").append(t).append(": ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            sb.append(n - 1);

            for (int i = 0; i <= n; i++) {
                int coeff = Integer.parseInt(st.nextToken());
                int currentDegree = n - i; // 현재 항의 차수
                
                if (currentDegree > 0) {
                    int derivedCoeff = coeff * currentDegree;
                    sb.append(" ").append(derivedCoeff);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}