import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dfs(0, new char[N]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int depth, char[] calOrder) {
        if(depth == N-1) {
            calculate(calOrder);
            return;
        }
        calOrder[depth] = ' ';
        dfs(depth + 1, calOrder);
        calOrder[depth] = '+';
        dfs(depth + 1, calOrder);
        calOrder[depth] = '-';
        dfs(depth + 1, calOrder);

    }
    private static void calculate(char[] calOrder) {
        int sum = 0;
        for(int i=N; i>1; i--) {
            int val = i;
            if(calOrder[i-2] == '+') {
                sum += val;
            } else if (calOrder[i-2] == '-') {
                sum -= val;
            } else {
                int tempVal = i;
                int cnt = 1;
                while(i-2 >= 0 && calOrder[i-2] == ' ') {
                    i--;
                    tempVal += i * Math.pow(10, cnt);
                    cnt++;
                }
                if(i-2 < 0) {
                    sum += tempVal;
                    continue;
                }
                if(calOrder[i-2] == '+') sum += tempVal;
                else if(calOrder[i-2] == '-') sum -= tempVal;
            }
        }
        if(calOrder[0] != ' ') sum += 1;
        if(sum == 0) printExpression(calOrder);
    }
    private static void printExpression(char[] calOrder) {
        for(int i=1; i<N; i++) {
            sb.append(i).append(calOrder[i-1]);
        }
        sb.append(N).append("\n");
    }
}