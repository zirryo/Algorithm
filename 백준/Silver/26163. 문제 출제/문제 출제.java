import java.io.*;
import java.util.*;

public class Main {
    static int[] b = new int[6];
    static int maxCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 5; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        findMaxCost(1, 0, 0, 0);

        System.out.println(maxCost);
    }

    static void findMaxCost(int difficulty, int totalCount, int totalDifficulty, int cost) {
        if (difficulty > 5) {
            boolean isValid = (totalCount <= 3 && totalDifficulty <= 10) || (totalCount >= 4);
            if (isValid) maxCost = Math.max(maxCost, cost);
            return;
        }

        for (int count = 0; count <= 15; count++) {
            int nextSum = totalDifficulty + (difficulty * count);
            if (nextSum > 15) break; // 더 이상 이 난이도 문제를 추가할 수 없음

            findMaxCost(difficulty + 1, totalCount + count,
                    nextSum, cost + (count * b[difficulty]));
        }
    }
}