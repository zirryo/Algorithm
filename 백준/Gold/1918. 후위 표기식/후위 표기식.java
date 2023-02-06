import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] list = br.readLine().toCharArray();

        for (char cur : list) {
            if (cur >= 'A' && cur <= 'Z') { // 피연산자일 경우 그대로 출력
                result.append(cur);
            } else {
                if (cur == '(') stack.push(cur);
                else if (cur == ')') { // 괄호 안의 연산자 출력
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    if (!stack.isEmpty()) stack.pop(); // 괄호가 남아있다면 스택에서 제거
                } else {
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(cur)) {
                        result.append(stack.pop());
                    }
                    stack.push(cur);
                }
            }
        }

        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.println(result);
    }
    
    private static int getPriority(char c) {
        if(c == '*' || c == '/') return 1; // 곱하기, 나누기 연산이 우선순위 높음
        else if(c == '+' || c == '-') return 0;
        else return -1; // 괄호는 출력하지 않으므로 가장 낮은 값 리턴
    }
}