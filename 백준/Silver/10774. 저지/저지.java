import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int J = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());

        int[] jersey = new int[J + 1];
        for (int i = 1; i <= J; i++) {
            jersey[i] = sizeToInt(br.readLine().charAt(0));
        }

        boolean[] used = new boolean[J + 1];
        int count = 0;

        for (int i = 0; i < A; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int requiredSize = sizeToInt(st.nextToken().charAt(0));
            int num = Integer.parseInt(st.nextToken());

            if (!used[num] && jersey[num] >= requiredSize) {
                used[num] = true;
                count++;
            }
        }

        System.out.println(count);
    }

    private static int sizeToInt(char size) {
        if (size == 'S') return 0;
        if (size == 'M') return 1;
        return 2;
    }
}
