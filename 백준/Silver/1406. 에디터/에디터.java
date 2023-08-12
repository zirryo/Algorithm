import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String original = br.readLine();
        for (int i = 0; i < original.length(); i++) {
            left.push(original.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            switch (s.charAt(0)) {
                case 'L' : {
                    if (left.isEmpty()) continue;
                    right.push(left.pop());
                    break;
                }
                case 'D' : {
                    if (right.isEmpty()) continue;
                    left.push(right.pop());
                    break;
                }
                case 'B' : {
                    if (left.isEmpty()) continue;
                    left.pop();
                    break;
                }
                default: {
                    left.push(s.charAt(2));
                }
            }
        }
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}