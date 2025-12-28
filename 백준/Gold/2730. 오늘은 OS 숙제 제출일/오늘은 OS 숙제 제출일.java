import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String deadlineStr = st.nextToken();
            String reportStr = st.nextToken();

            String[] dParts = deadlineStr.split("/");
            int dMonth = Integer.parseInt(dParts[0]);
            int dDay = Integer.parseInt(dParts[1]);
            int dYear = Integer.parseInt(dParts[2]);

            String[] rParts = reportStr.split("/");
            int rMonth = Integer.parseInt(rParts[0]);
            int rDay = Integer.parseInt(rParts[1]);

            LocalDate deadline = LocalDate.of(dYear, dMonth, dDay);

            long minDiff = Long.MAX_VALUE;
            LocalDate bestDate = null;

            int[] years = {dYear, dYear - 1, dYear + 1};

            for (int y : years) {
                if (y < 1999 || y > 2201) continue;

                if (rMonth == 2 && rDay == 29 && !isLeap(y)) continue;

                LocalDate reportDate = LocalDate.of(y, rMonth, rDay);
                long diff = ChronoUnit.DAYS.between(deadline, reportDate);

                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                    bestDate = reportDate;
                } else if (Math.abs(diff) == Math.abs(minDiff)) {
                    if (y == dYear) {
                        minDiff = diff;
                        bestDate = reportDate;
                    }
                }
            }

            if (bestDate == null || Math.abs(minDiff) > 7) {
                sb.append("OUT OF RANGE\n");
            } else {
                String formattedDate = String.format("%d/%d/%d", rMonth, rDay, bestDate.getYear());
                if (minDiff == 0) {
                    sb.append("SAME DAY\n");
                } else if (minDiff > 0) {
                    sb.append(formattedDate + " IS " + minDiff);
                    sb.append((minDiff > 1) ? " DAYS AFTER\n" : " DAY AFTER\n");
                } else {
                    sb.append(formattedDate + " IS " + Math.abs(minDiff));
                    sb.append((Math.abs(minDiff) > 1) ? " DAYS PRIOR\n" : " DAY PRIOR\n");
                }
            }
        }
        System.out.println(sb);
    }

    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}