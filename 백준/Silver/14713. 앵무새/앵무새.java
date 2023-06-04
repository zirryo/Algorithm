import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Queue<String>[] wordQ = new Queue[N];
        for (int i = 0; i < N; i++) {
            wordQ[i] = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) wordQ[i].add(st.nextToken());
        }

        boolean flag = false;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
            flag = false;
            for (int i = 0; i < N; i++) {
                if (wordQ[i].isEmpty()) continue;
                if (Objects.equals(wordQ[i].peek(), cur)) {
                    wordQ[i].poll();
                    flag = true;
                }
            }

            if (!flag) break;
        }

        for (int i=0; i<N; i++) {
            if (!wordQ[i].isEmpty()) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println("Possible");
        else System.out.println("Impossible");
    }
}