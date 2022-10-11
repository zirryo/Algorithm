import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int[] histogram;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            histogram = new int[N];
            for(int i=0; i<N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(N)).append("\n");
            histogram = null;
        }
        System.out.println(sb);
    }
    public static long getArea(int len) {
        Stack<Integer> stack = new Stack<>();
        long max = 0;

        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                int height = histogram[stack.pop()];
                long width = stack.isEmpty() ? i : i-1-stack.peek();
                max = Math.max(max, height*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int height = histogram[stack.pop()];
            long width = stack.isEmpty() ? len : len-1-stack.peek();
            max = Math.max(max, height*width);
        }
        return max;
    }
}