import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<ToDo> stack = new Stack<>();
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x == 0) {
                if (!stack.isEmpty()) {
                    stack.peek().keepGoing();
                }
            } else {
                int a = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                stack.push(new ToDo(a, t-1)); // 받자마자 바로 수행 (1분 감소)
            }

            if (!stack.isEmpty() && stack.peek().time == 0) {
                result += stack.pop().score;
            }
        }

        System.out.println(result);
    }
}
class ToDo {
    int score;
    int time;

    public ToDo(int score, int time) {
        this.score = score;
        this.time = time;
    }

    public void keepGoing() {
        this.time--;
    }
}