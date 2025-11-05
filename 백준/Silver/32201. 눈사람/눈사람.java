import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, Integer> pos = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            pos.put(num, i);
        }

        long[] B = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        int maxGain = Integer.MIN_VALUE;
        int[] gain = new int[N];

        for (int i = 0; i < N; i++) {
            int startPos = pos.get(B[i]);
            int endPos = i;
            gain[i] = startPos - endPos; 
            if (gain[i] > maxGain) {
                maxGain = gain[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (gain[i] == maxGain) {
                sb.append(B[i]).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
