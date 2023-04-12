import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Question[] arr = new Question[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Question(d, c);
        }
        Arrays.parallelSort(arr); // 멀티 쓰레드 사용, 요소 5000개 이상이면 효과적
        for(Question cur : arr) {
            int day = pq.size();
            if(day < cur.due) pq.add(cur.cup);
            else if (day == cur.due) {
                int cups = pq.peek();
                if(cups < cur.cup) {
                    pq.poll();
                    pq.add(cur.cup);
                }
            }
        }
        while (!pq.isEmpty()) result += pq.poll();
        System.out.println(result);
    }
    private static class Question implements Comparable<Question> {
        int due;
        int cup;

        public Question(int due, int cup) {
            this.due = due;
            this.cup = cup;
        }
        @Override
        public int compareTo(Question q) {
            if(this.due == q.due) return q.cup - this.cup;
            return this.due - q.due;
        }
    }
}