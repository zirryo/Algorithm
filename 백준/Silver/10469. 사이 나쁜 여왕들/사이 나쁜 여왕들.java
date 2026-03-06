import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> queens = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == '*') {
                    queens.add(new int[]{i, j});
                }
            }
        }

        if (isValid(queens)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    static boolean isValid(List<int[]> queens) {
        if (queens.size() != 8) return false;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                int[] q1 = queens.get(i);
                int[] q2 = queens.get(j);

                if (q1[0] == q2[0] || q1[1] == q2[1]) return false;
                
                if (Math.abs(q1[0] - q2[0]) == Math.abs(q1[1] - q2[1])) return false;
            }
        }

        return true;
    }
}