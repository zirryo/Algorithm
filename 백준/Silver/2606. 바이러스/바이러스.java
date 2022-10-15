import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean isVisited[];
    public static boolean arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        isVisited = new boolean[N+1];
        arr = new boolean[N+1][N+1];

        while(K-->0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = arr[end][start] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;

        int cnt = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i=1; i<=N; i++) {
                if(arr[temp][i]==true && !isVisited[i]) {
                    isVisited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}