import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // stack 에는 arr 의 인덱스값을 넣음

        for(int i=1; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i]; // arr 의 값 탐색은 1회성 이므로 결과값을 다시 arr 에 넣음
            }
            stack.push(i); // 새로운 값이 기존 값 보다 작을 경우 pop 하지 않고 push 만 수행
        }

        while(!stack.isEmpty()) {
            arr[(stack).pop()] = -1; // 오큰수가 없는 경우 -1로 fill
        }

        for(int i : arr) sb.append(i).append(" ");
        System.out.println(sb);
    }
}