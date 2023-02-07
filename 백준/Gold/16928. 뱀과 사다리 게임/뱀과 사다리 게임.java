import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] board = new int[101];
    static final int START = 1;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=100; i++) board[i] = i;

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            board[s] = e;
        }

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(START);

        int[] cntArr = new int[101];
        cntArr[START] = 0;

        while(!q.isEmpty()) {
            int curNode = q.poll();

            for(int i=1; i<=6; i++) {
                int nextNode = curNode + i;

                if(nextNode > 100) continue;

                if(cntArr[board[nextNode]] == 0) { // 미방문 노드일 경우
                   q.offer(board[nextNode]);
                   cntArr[board[nextNode]] = cntArr[curNode] + 1;
                }

                if(board[nextNode] == 100) {
                    result = cntArr[100];
                    break;
                }
            }
        }
    }
}