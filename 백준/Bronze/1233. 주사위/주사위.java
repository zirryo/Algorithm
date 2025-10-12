import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());
        
        int maxSum = S1 + S2 + S3;
        int[] count = new int[maxSum + 1];
        
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    count[i + j + k]++;
                }
            }
        }

        int maxCount = 0;
        int answer = 0;

        for (int sum = 3; sum <= maxSum; sum++) {
            if (count[sum] > maxCount) {
                maxCount = count[sum];
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}
