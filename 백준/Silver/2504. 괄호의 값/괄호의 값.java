import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int result = 0;
        int val = 1;
        boolean flag = false;

        for(int i=0; i<str.length(); i++) {
            if(flag) break;

            switch (str.charAt(i)) {
                case '(': {
                    stack.push('(');
                    val *= 2;
                    break;
                }
                case ')': {
                    if(stack.empty() || stack.peek() !='(') {
                        result = 0; // 올바른 괄호열이 아님
                        flag = true;
                        break;
                    } else if (str.charAt(i-1) == '(') {
                        result += val;
                    }
                    stack.pop();
                    val /= 2;
                    break;
                }
                case '[': {
                    stack.push('[');
                    val *= 3;
                    break;
                }
                case ']': {
                    if(stack.empty() || stack.peek() !='[') {
                        result = 0; // 올바른 괄호열이 아님
                        flag = true;
                        break;
                    } else if (str.charAt(i-1) == '[') {
                        result += val;
                    }
                    stack.pop();
                    val /= 3;
                    break;
                }
            }
        }
        if(!stack.empty()) result = 0;
        System.out.println(result);
    }

}