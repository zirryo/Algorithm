import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> files;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxLength = 0;
        files = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> file = new ArrayList<>();

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break; 
                file.add(num);
            }

            files.add(file);
            maxLength = Math.max(maxLength, file.size()); 
        }
        
        int left = 1, right = maxLength, answer = maxLength;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDistinguish(mid)) {
                answer = mid;  
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
    
    private static boolean canDistinguish(int K) {
        Set<String> seen = new HashSet<>();

        for (List<Integer> file : files) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < K; i++) {
                if (i < file.size()) {
                    sb.append(file.get(i)).append(",");
                } else {
                    sb.append("0,"); 
                }
            }

            if (!seen.add(sb.toString())) return false; 
        }

        return true; 
    }
}
