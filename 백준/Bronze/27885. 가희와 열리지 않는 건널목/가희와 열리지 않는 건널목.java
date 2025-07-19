import java.util.*;
import java.io.*;

public class Main {

    static class Interval implements Comparable<Interval> {
        int start, end;
        Interval(int start) {
            this.start = start;
            this.end = start + 40;
        }
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

    static int toSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TOTAL_SECONDS = 24 * 60 * 60;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        List<Interval> trains = new ArrayList<>();

        for (int i = 0; i < c + h; i++) {
            String time = br.readLine();
            trains.add(new Interval(toSeconds(time)));
        }

        Collections.sort(trains);

        int blockedTime = 0;
        int currentStart = -1;
        int currentEnd = -1;

        for (Interval t : trains) {
            if (t.start > currentEnd) {
                blockedTime += (currentEnd - currentStart);
                currentStart = t.start;
                currentEnd = t.end;
            } else {
                currentEnd = Math.max(currentEnd, t.end);
            }
        }
        blockedTime += (currentEnd - currentStart);

        System.out.println(TOTAL_SECONDS - blockedTime);
    }
}
