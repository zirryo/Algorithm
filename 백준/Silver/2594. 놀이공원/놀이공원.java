import java.util.*;

public class Main {
    static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int start, int end) {
            this.start = Math.max(600, start - 10); 
            this.end = Math.min(1320, end + 10);    
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static int timeToMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(2, 4));
        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] times = sc.nextLine().split(" ");
            int start = timeToMinutes(times[0]);
            int end = timeToMinutes(times[1]);
            intervals.add(new Interval(start, end));
        }

        Collections.sort(intervals);

        List<Interval> merged = new ArrayList<>();
        for (Interval cur : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).end < cur.start) {
                merged.add(cur);
            } else {
                Interval last = merged.get(merged.size() - 1);
                last.end = Math.max(last.end, cur.end);
            }
        }

        int maxRest = 0;
        int prevEnd = 600; // 오전 10시 시작

        for (Interval cur : merged) {
            if (cur.start > prevEnd) {
                maxRest = Math.max(maxRest, cur.start - prevEnd);
            }
            prevEnd = Math.max(prevEnd, cur.end);
        }
        
        if (prevEnd < 1320) {
            maxRest = Math.max(maxRest, 1320 - prevEnd);
        }

        System.out.println(maxRest);
    }
}
