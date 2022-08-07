import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        // 중복 제거, 순위 매기기 가능한 해시맵 구조 사용
        HashMap<Integer,Integer> result = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        int rank = 0;
        for(int i : sorted) {
            if(!result.containsKey(i)) {
                result.put(i,rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            sb.append(result.get(key)).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));

    }
}