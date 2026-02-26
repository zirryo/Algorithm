import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> numCnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                numCnt.put(val, numCnt.getOrDefault(val, 0) + 1);
            }
        }

        int oddCount = 0;
        for (int count : numCnt.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        if (M % 2 == 0) {
            if (oddCount == 0) System.out.println("YES");
            else System.out.println("NO");
        } else {
            if (oddCount <= N) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}