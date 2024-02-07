import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : input) {
            if (c == '(') stack.push(0);
            else if (c == 'H') {
                stack.push(1);
            } else if (c == 'C') {
                stack.push(12);
            } else if (c == 'O') {
                stack.push(16);
            } else if (c >= '2' && c <= '9') {
                stack.push(stack.pop() * (c - '0'));
            } else { // 닫는 괄호
                int temp = 0;
                while (true) {
                    if (stack.peek() == 0) {
                        stack.pop();
                        stack.push(temp);
                        break;
                    } else {
                        temp += stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}