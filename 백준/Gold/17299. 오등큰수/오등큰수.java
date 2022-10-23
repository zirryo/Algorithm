import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        int[] cnt = new int[1000001];
        int maxCnt = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++; // 등장 횟수 카운트
        }

        for(int i=N-1; i>=0; i--) { // 우측부터 탐색
            int tempCnt = cnt[arr[i]];
            if(!stack.isEmpty() && tempCnt>=maxCnt) stack.clear();
            maxCnt = Math.max(maxCnt, tempCnt);
            
            while(!stack.isEmpty()) {
                int idx = stack.peek();
                if(cnt[arr[idx]] > tempCnt) {
                    result[i] = arr[idx];
                    break;
                } else {
                    stack.pop();
                }
            }
            
            if(stack.isEmpty()) result[i] = -1;
            stack.push(i);
        }

        for(int i : result) sb.append(i).append(" ");
        System.out.println(sb);
    }
}