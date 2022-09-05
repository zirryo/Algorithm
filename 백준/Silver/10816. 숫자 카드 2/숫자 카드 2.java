import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int key = Integer.parseInt(st.nextToken());
            hashMap.put(key,hashMap.getOrDefault(key,0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            int resultKey = Integer.parseInt(st.nextToken());
            sb.append(hashMap.getOrDefault(resultKey, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
