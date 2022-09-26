import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;

            if(isBalanced(s)) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[') stack.push(c);
            else if (c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();

            } else if (c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}