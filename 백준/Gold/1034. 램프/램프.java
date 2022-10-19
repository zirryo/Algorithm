import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> rows = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] table = new String[N];

        for(int i=0; i<N; i++) table[i] = br.readLine();

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int zero = 0;
            for(int j=0; j<M; j++) {
                zero = (table[i].charAt(j) == '0') ? zero+1 : zero;
            }
            if(K>=zero && (K%2 == zero%2)) rows.put(table[i], rows.getOrDefault(table[i],0)+1);
        }
        List<String> rowList = new ArrayList<>(rows.keySet());
        Collections.sort(rowList, ((o1, o2) -> rows.get(o2).compareTo(rows.get(o1))));

        if(!rows.isEmpty()) System.out.println(rows.get(rowList.get(0)));
        else System.out.println(0);
    }
}