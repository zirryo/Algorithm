import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int solution(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return 0;
        }

        int count = 0;

        for (int x = 0; x < length; x++) {
            if (isValid(s, x, length)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(String s, int offset, int length) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt((offset + i) % length);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}