import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> dq;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[],"); // 구분하고 싶은 문자열을 연속해서 작성
            dq = new ArrayDeque<>();

            for(int i=0; i<N; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            ac(command, dq);
        }
        System.out.println(sb);
    }
    public static void ac(String command, ArrayDeque<Integer> dq) {
        boolean isFront = true; // 정방향

        for(char c : command.toCharArray()) {
            if(c == 'R') {
                isFront = !isFront; // 방향 바꾸기
                continue;
            }
            if(dq.isEmpty()) {
                sb.append("error\n");
                return;
            } else {
                if(isFront) dq.pollFirst();
                else dq.pollLast();
            }
        }
        dqToString(dq, isFront);

    }
    public static void dqToString(ArrayDeque<Integer> dq, boolean isFront) {
        sb.append("[");

        if(!dq.isEmpty()) {
            if(isFront) {
                sb.append(dq.pollFirst());
                while(!dq.isEmpty()) sb.append(",").append(dq.pollFirst());
            } else {
                sb.append(dq.pollLast());
                while(!dq.isEmpty()) sb.append(",").append(dq.pollLast());
            }
        }
        sb.append("]").append("\n");
    }
}