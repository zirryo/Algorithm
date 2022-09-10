import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stack = new int[10000];
    static int size = 0;
    static int top = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push": {
                    push(Integer.parseInt(s[1]));
                    break;
                }
                case "pop": {
                    pop();
                    break;
                }
                case "size": {
                    size();
                    break;
                }
                case "empty": {
                    empty();
                    break;
                }
                case "top": {
                    top();
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    static void push(int x) {
        stack[top] = x;
        top++;
        size++;
    }

    static void pop() {
        if(size == 0) sb.append(-1).append("\n");
        else {
            sb.append(stack[top-1]).append("\n");
            top--;
            size--;
        }
    }

    static void size() {
        sb.append(size).append("\n");
    }

    static void empty() {
        if(size == 0) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }

    static void top() {
        if(size == 0) sb.append(-1).append("\n");
        else sb.append(stack[top-1]).append("\n");
    }
}