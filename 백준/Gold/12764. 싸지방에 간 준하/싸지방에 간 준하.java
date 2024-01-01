import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N+1];
        StringTokenizer st;
        ArrayList<Time> times = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new Time(s, e));
        }

        Collections.sort(times);
        PriorityQueue<Compu> running = new PriorityQueue<>();
        PriorityQueue<Integer> waiting = new PriorityQueue<>();
        int totalComputers = 0;

        for (Time t : times) {
            while (!running.isEmpty()) {
                if (t.start > running.peek().occupied) {
                    waiting.add(running.poll().num);
                } else {
                    break;
                }
            }

            if (waiting.isEmpty()) { // 빈 좌석이 없는 경우 -> 신규 좌석 추가
                totalComputers++;
                running.add(new Compu(t.end, totalComputers));
                cnt[totalComputers]++;
            } else { // 빈 좌석이 있는 경우 -> 가장 번호가 빠른 자리 선택
                running.add(new Compu(t.end, waiting.peek()));
                cnt[waiting.poll()]++;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(totalComputers).append("\n");
        for (int i=1; i<=totalComputers; i++) {
            result.append(cnt[i]).append(" ");
        }
        System.out.println(result);
    }
}
class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time time) {
        return this.start - time.start;
    }
}
class Compu implements Comparable<Compu> {
    int occupied;
    int num;

    public Compu(int occupied, int num) {
        this.occupied = occupied;
        this.num = num;
    }

    @Override
    public int compareTo(Compu compu) {
        return this.occupied - compu.occupied;
    }
}