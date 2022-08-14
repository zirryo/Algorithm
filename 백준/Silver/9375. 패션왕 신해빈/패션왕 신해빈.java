import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int clothes = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            for(int j=0; j<clothes; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String kind = st.nextToken();

                if(hm.containsKey(kind)) hm.put(kind,hm.get(kind)+1);
                else hm.put(kind, 1);
            }
            int result = 1;
            for(int k : hm.values()) {
                result *= (k+1);
            }
            sb.append(result-1).append("\n");

        }
        System.out.println(sb);
    }
}