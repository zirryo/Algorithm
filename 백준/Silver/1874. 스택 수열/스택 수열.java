import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int count = 0; // 어느 숫자까지 사용했는 지 확인하기 위한 카운트

        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num > count)  {
                for(int i = count+1; i<=num; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                count = num;
            }
            else if(stack.peek() != num) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
