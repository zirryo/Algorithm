import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BitSet[] rowA = new BitSet[N]; // A는 행단위로 BitSet 저장
        for (int i = 0; i < N; i++) {
            rowA[i] = new BitSet(N);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    rowA[i].set(j);
                }
            }
        }

        BitSet[] colB = new BitSet[N]; // B는 열단위로 BitSet 저장
        for (int i = 0; i < N; i++) {
            colB[i] = new BitSet(N);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    colB[j].set(i);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (rowA[i].isEmpty()) continue;

            for (int j = 0; j < N; j++) {
                if (colB[j].isEmpty()) continue;

                BitSet temp = (BitSet) rowA[i].clone();
                temp.and(colB[j]);

                if (!temp.isEmpty()) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}