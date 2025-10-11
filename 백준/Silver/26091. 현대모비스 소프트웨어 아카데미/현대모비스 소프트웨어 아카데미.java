import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0, right = N - 1;
        int teamCount = 0;

        while (left < right) {
            if (arr[left] + arr[right] >= M) {
                teamCount++;
                left++;
                right--;
            } else {
                left++;
            }
        }

        System.out.println(teamCount);
    }
}
