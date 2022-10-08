import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        int[] seq = new int[M];

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i=1; i<=N; i++) deque.offer(i);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) seq[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            int targetIdx = deque.indexOf(seq[i]);
            int mid;
            if(deque.size() % 2 == 0) mid = deque.size() / 2 - 1;
            else mid = deque.size() / 2;

            if(targetIdx <= mid) {
                for(int j=0; j<targetIdx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } else {
                for(int j=0; j<deque.size()-targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}