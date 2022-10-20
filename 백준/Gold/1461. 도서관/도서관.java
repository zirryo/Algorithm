import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>((o1, o2) -> o2-o1); // 내림차순 정렬
        PriorityQueue<Integer> neg = new PriorityQueue<>((o1, o2) -> o2-o1); // 내림차순 정렬

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max;
        int step = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(k<0) neg.add(Math.abs(k));
            else pos.add(k);
        }

        if(pos.isEmpty()) max = neg.peek();
        else if(neg.isEmpty()) max = pos.peek();
        else max = Math.max(neg.peek(), pos.peek());

        while(!pos.isEmpty()) {
            int tempP = pos.poll();
            step += (tempP*2);
            for(int i=1; i<M; i++) {
                pos.poll();
                if(pos.isEmpty()) break;
            }
        }

        while(!neg.isEmpty()) {
            int tempN = neg.poll();
            step += (tempN*2);
            for(int i=1; i<M; i++) {
                neg.poll();
                if(neg.isEmpty()) break;
            }
        }
        step -= max; // 가장 먼 곳을 마지막에 방문하여 다시 제자리로 돌아오지 않도록 함.
        System.out.println(step);
    }
}