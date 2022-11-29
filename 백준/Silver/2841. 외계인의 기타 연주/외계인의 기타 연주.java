import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, P;
    static int move = 0;
    static Stack<Integer>[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        s = new Stack[N+1];

        for(int i=0; i<N; i++) s[i] = new Stack<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            if(s[line].size() == 0) { // case1:라인에 아무것도 안 누르고 있는 경우
                move++;
                s[line].push(fret);
                continue;
            }

            while(s[line].peek() > fret) { // case2:라인에 더 큰 프렛이 눌려 있는 경우
                move++;
                s[line].pop();

                if(s[line].size() == 0) break;
            }

            if(s[line].size() != 0 && s[line].peek() == fret) continue; // case3:이미 해당 프렛이 눌려있는 경우

            move++; // case4:나머지 경우
            s[line].push(fret);
        }
        System.out.println(move);
    }

}