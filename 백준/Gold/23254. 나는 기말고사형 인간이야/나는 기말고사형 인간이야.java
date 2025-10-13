import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Subject implements Comparable<Subject> {
        int score;
        int rate;

        Subject(int score, int rate) {
            this.score = score;
            this.rate = rate;
        }

        @Override
        public int compareTo(Subject other) {
            int thisGain = Math.min(100 - this.score, this.rate);
            int otherGain = Math.min(100 - other.score, other.rate);
            return Integer.compare(otherGain, thisGain);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Subject> pq = new PriorityQueue<>();

        int totalHours = Integer.parseInt(st.nextToken()) * 24;
        int M = Integer.parseInt(st.nextToken());
        int[] scores = new int[M];
        int totalScore = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            pq.add(new Subject(scores[i], Integer.parseInt(st.nextToken())));
        }

        for (int hour = 0; hour < totalHours; hour++) {
            if (pq.isEmpty()) break;

            Subject cur = pq.poll();
            int nextScore = Math.min(100, cur.score + cur.rate);

            if (nextScore == 100) {
                totalScore += 100;
                continue;
            }

            pq.add(new Subject(nextScore, cur.rate));
        }

        while (!pq.isEmpty()) {
            totalScore += pq.poll().score;
        }

        System.out.println(totalScore);
    }
}
