import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine()); // 스택 최대 크기
        while(true) {
            int K = Integer.parseInt(br.readLine());
            if(K==-1) break;
            else if(K > 0){
                if(q.size()<N) q.offer(K);
            } else {
                q.poll();
            }
        }

        if(q.isEmpty()) {
            System.out.println("empty");
            System.exit(0);
        }

        while(!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
        }

        System.out.println(sb);
    }
}