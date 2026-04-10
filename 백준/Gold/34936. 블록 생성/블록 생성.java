import java.io.*;
import java.util.*;

public class Main {
    static class Transaction implements Comparable<Transaction> {
        int time, fee, id;

        Transaction(int time, int fee, int id) {
            this.time = time;
            this.fee = fee;
            this.id = id;
        }

        @Override
        public int compareTo(Transaction o) {
            if (this.fee != o.fee) return o.fee - this.fee;
            return this.id - o.id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Transaction> feePQ = new PriorityQueue<>(); // 수수료 내림차순 정렬
        Queue<Transaction> timeQ = new LinkedList<>(); // 전체 트랜잭션
        boolean[] isRemoved = new boolean[N + 1];

        long totalFeeSum = 0;
        int tranId = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int t = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                Transaction tx = new Transaction(t, f, tranId++);
                feePQ.add(tx);
                timeQ.add(tx);
            } else {
                int curTime = Integer.parseInt(st.nextToken());
                int startTime = curTime - T;

                while (!timeQ.isEmpty() && timeQ.peek().time < startTime) {
                    Transaction expired = timeQ.poll();
                    isRemoved[expired.id] = true;
                }

                int count = 0;
                while (count < K && !feePQ.isEmpty()) {
                    Transaction tx = feePQ.poll();
                    if (isRemoved[tx.id]) continue;

                    totalFeeSum += tx.fee;
                    isRemoved[tx.id] = true;
                    count++;
                }
            }
        }
        System.out.println(totalFeeSum);
    }
}