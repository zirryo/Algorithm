import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] table = new char[R][C];
        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().toCharArray();
        }

        int left = 0, right = R - 1, answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isUnique(table, mid, R, C)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isUnique(char[][] table, int startRow, int R, int C) {
        Set<String> set = new HashSet<>();

        for (int col = 0; col < C; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = startRow; row < R; row++) {
                sb.append(table[row][col]);
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }

        return true;
    }
}
