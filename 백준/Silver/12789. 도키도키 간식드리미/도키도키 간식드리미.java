import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> now = new LinkedList<>();
        Stack<Integer> other = new Stack<>();
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int K = Integer.parseInt(st.nextToken());
            now.add(K);
        }

        Outer:
        while (!now.isEmpty()) {
            int nowCur = now.poll();
            if (nowCur == cnt + 1) { // 자신의 순서인 경우
                cnt++;
            } else { // 순서가 아닌 경우
                while (!other.isEmpty()) {
                    int otherCur = other.peek();
                    if (otherCur == cnt + 1) {
                        other.pop();
                        cnt++;
                    } else if (otherCur < nowCur) {
                        break Outer; // 모두가 간식을 받을 수 없는 경우
                    } else {
                        break;
                    }
                }
                other.push(nowCur);
            }
        }
        while (!other.isEmpty()) {
            int cur = other.pop();
            if (cur == cnt + 1) {
                cnt++;
            } else {
                break;
            }
        }
        if (cnt == N) System.out.println("Nice");
        else System.out.println("Sad");
    }
}