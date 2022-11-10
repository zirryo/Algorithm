import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
        int W = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        for(int i=0; i<W; i++) q.offer(0); // 다리 길이만큼 큐에 공간 생성
        int weight = 0;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        int truck =Integer.parseInt(st.nextToken());

        while(true) {
            cnt++; // 반복문이 실행될 때 마다 시간이 1씩 흐름
            weight -= q.poll();

            if(weight+truck <= L) {
                q.offer(truck);
                weight += truck;
                N--;
                if(N==0) break;
                truck = Integer.parseInt(st.nextToken());
            } else { // 트럭을 다리에 추가할 수 없는 경우 0을 큐에 넣어서 시간만 흐르도록 함
                q.offer(0);
            }
        }
        cnt += W; // 마지막 트럭이 건너는 시간을 더함.
        System.out.println(cnt);
    }
}