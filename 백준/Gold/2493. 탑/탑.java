import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 탑의 개수
        int[] towers = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(N); // 스택에는 배열의 인덱스 값 삽입

        for(int i=N-1; i>=1; i--) {
            while(!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                towers[stack.pop()] = i; // towers 의 값 탐색은 1회성 이므로 결과값을 다시 towers 에 넣음
            }
            stack.push(i); // 새로운 값이 기존 값 보다 작을 경우 pop 하지 않고 push 만 수행
        }

        while(!stack.isEmpty()) {
            towers[stack.pop()] = 0;
        }

        for(int i=1; i<=N; i++) sb.append(towers[i]).append(" ");
        System.out.println(sb);
    }
}