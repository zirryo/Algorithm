import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        while(T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 수
            int M = Integer.parseInt(st.nextToken()); // 출력 순서가 궁금한 문서
            int print = 0; // 출력 횟수
            LinkedList<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});

            while(!queue.isEmpty()) {
                int[] front = queue.poll();
                boolean isMax = true;

                for(int i=0; i< queue.size(); i++) {
                    if(front[1] < queue.get(i)[1]) { // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 크면
                        queue.offer(front); // 처음 뽑은 원소 + 지금까지 지나친 원소 뒤로 보내기
                        for(int j=0; j<i; j++) queue.offer(queue.poll());
                        isMax = false;
                        break;
                    }
                }

                if(isMax == false) continue; // 뽑은 원소가 가장 큰 수가 아님 -> 다음 반복문으로

                print++; // skip 되지 않고 여기까지 코드가 진행된 경우 -> 현재 큐에서 가장 우선 순위 높으므로 출력
                if(front[0] == M) break; // 찾고자하는 문서일 경우 while 문 탈출
            }
            sb.append(print + "\n");
        }
        System.out.println(sb);
    }
}