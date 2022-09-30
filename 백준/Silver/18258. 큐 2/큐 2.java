import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] queue = new int[2000000];
    static int size = 0;
    static int front = 0;
    static int back = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": pop(); break;
                case "size" : size(); break;
                case "empty" : empty(); break;
                case "front" : front(); break;
                case "back" : back(); break;
            }
        }
        System.out.println(sb);
    }
    static void push(int n) {
        queue[back] = n;
        back++;
        size++;
    }
    static void pop() {
        if(size==0) sb.append("-1\n");
        else {
            sb.append(queue[front]).append("\n");
            front++;
            size--;
        }
    }
    static void size() {
        sb.append(size + "\n");
    }
    static void empty() {
        if(size==0) sb.append("1\n");
        else sb.append("0\n");
    }
    static void front() {
        if(size==0) sb.append("-1\n");
        else {
            sb.append(queue[front]).append("\n");
        }
    }
    static void back() {
        if(size==0) sb.append("-1\n");
        else {
            sb.append(queue[back-1]).append("\n");
        }
    }

}