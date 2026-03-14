import java.io.*;
import java.util.*;

public class Main {
    static class Event implements Comparable<Event> {
        int time, type;

        Event(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            if (this.time == o.time) return this.type - o.type;
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();

            int sTime = convertToMonth(start);
            int eTime = convertToMonth(end) + 1;

            events.add(new Event(sTime, 1));
            events.add(new Event(eTime, -1));
        }

        Collections.sort(events);

        int maxFriends = 0;
        int curFriends = 0;
        int maxTime = events.get(0).time;

        for (Event e : events) {
            curFriends += e.type;
            if (curFriends > maxFriends) {
                maxFriends = curFriends;
                maxTime = e.time;
            }
        }

        System.out.println(convertToFormat(maxTime));
    }

    static int convertToMonth(String date) {
        String[] part = date.split("-");
        int y = Integer.parseInt(part[0]);
        int m = Integer.parseInt(part[1]);
        return y * 12 + m;
    }

    static String convertToFormat(int totalMonth) {
        int y = (totalMonth - 1) / 12;
        int m = (totalMonth - 1) % 12 + 1;
        return String.format("%04d-%02d", y, m);
    }
}