import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(!set.add(k)) {
                sb.append(1).append("\n");
            } else {
                set.remove(k); 
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}