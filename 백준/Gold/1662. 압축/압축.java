import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> lenStack = new Stack<>();
        Stack<Integer> mulStack = new Stack<>();
        int val = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int mul = s.charAt(i-1) - '0';
                mulStack.push(mul);
                lenStack.push(--val);
                val = 0;
            } else if (c == ')') {
                int temp = mulStack.pop() * val;
                val = lenStack.pop() + temp;
            } else {
                val++;
            }
        }
        System.out.println(val);
    }
}