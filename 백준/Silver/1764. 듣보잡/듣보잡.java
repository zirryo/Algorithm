import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> hs = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<N; i++) {
            hs.add(br.readLine());
        }
        for(int j=0; j<M; j++) {
            String str = br.readLine();
            if(hs.contains(str)) result.add(str);
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        for(int i=0; i< result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);

    }

}
