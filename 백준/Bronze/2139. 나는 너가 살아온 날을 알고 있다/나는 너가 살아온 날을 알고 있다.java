import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean isLeap(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] daysNormal = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysLeap   = {31,29,31,30,31,30,31,31,30,31,30,31};

        while (true) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (d == 0 && m == 0 && y == 0) break;

            int[] days = isLeap(y) ? daysLeap : daysNormal;

            int total = 0;
            for (int i = 0; i < m - 1; i++) {
                total += days[i];
            }
            total += d;

            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}
