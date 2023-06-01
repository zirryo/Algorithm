import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            getPassword(br.readLine());
        }

        System.out.println(sb);
    }
    private static void getPassword(String s) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '>') {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (c == '<') {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (c == '-') {
                if (!left.isEmpty()) left.pop();
            } else {
                left.push(c);
            }
        }

        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        sb.append("\n");
    }
}