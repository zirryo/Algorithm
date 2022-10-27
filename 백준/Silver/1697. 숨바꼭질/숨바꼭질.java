import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int isVisited[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = bfs(N);
        System.out.println(count);
    }

    static int bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        int temp = 0;
        isVisited[x] = 1;

        while(!q.isEmpty()) {
            temp = q.poll();
            if(temp == K) return isVisited[temp] -1; // 시작점의 방문처리를 위해 1로 변경했으므로 결과값 -1

            if(temp-1 >= 0 && isVisited[temp-1] == 0) {
                isVisited[temp-1] = isVisited[temp] + 1;
                q.offer(temp-1);
            }
            if(temp+1 <= 100000 && isVisited[temp+1] == 0) {
                isVisited[temp+1] = isVisited[temp] + 1;
                q.offer(temp+1);
            }
            if(2*temp <=100000 && isVisited[2*temp] == 0) {
                isVisited[2*temp] = isVisited[temp] + 1;
                q.offer(2*temp);
            }
        }
        return -1; // 값을 찾을 수 없는 경우
    }
}