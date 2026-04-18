import java.io.*;
import java.util.*;

public class Main {
    static final int[] DAYS_IN_MONTH = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] usedNum = new boolean[10];

            for (int i = 0; i < 10; i++) {
                if (st.nextToken().equals("1")) {
                    usedNum[i] = true;
                }
            }

            int possibleDays = 0;

            for (int month = 1; month <= 12; month++) {
                // 해당 월의 1일부터 마지막 날까지 순회
                for (int day = 1; day <= DAYS_IN_MONTH[month]; day++) {
                    if (isValid(month, day, usedNum)) {
                        possibleDays++;
                    }
                }
            }
            sb.append(possibleDays).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isValid(int month, int day, boolean[] idDigits) {
        if (month >= 10) {
            if (idDigits[month / 10] || idDigits[month % 10]) return false;
        } else {
            if (idDigits[month]) return false;
        }

        if (day >= 10) {
            if (idDigits[day / 10] || idDigits[day % 10]) return false;
        } else {
            if (idDigits[day]) return false;
        }

        return true;
    }
}