import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N, sameCnt;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int height = Integer.parseInt(br.readLine());
            sameCnt = 1;
            while(!stack.isEmpty() && stack.peek()[0] < height) {
                result += stack.peek()[1];
                stack.pop();
            }

            if(!stack.isEmpty()) {
                if(stack.peek()[0] == height) {
                    result += stack.peek()[1];
                    sameCnt = stack.peek()[1] + 1;
                    if(stack.size() > 1) result++;
                    stack.pop();
                } else result++;
            }

            stack.push(new int[]{height, sameCnt});
        }
        System.out.println(result);
    }
}