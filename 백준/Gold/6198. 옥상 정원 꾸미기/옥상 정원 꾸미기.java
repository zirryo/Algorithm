import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 빌딩의 개수
        int[] buildings = new int[N];

        for(int i=0; i<N; i++) buildings[i] = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        long cnt = 0;

        s.push(0);

        for(int i=1; i<N; i++) {
            if(buildings[i] < buildings[s.peek()]) {
                s.push(i);
                cnt += s.size() - 1;
            }
            else {
                while(!s.isEmpty() && buildings[i] >= buildings[s.peek()]) {
                    s.pop();
                }
                s.push(i);
                cnt += s.size() - 1;
            }
        }
        System.out.println(cnt);
    }

}