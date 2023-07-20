import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            switch (com) {
                case 1 : {
                    int x = Integer.parseInt(st.nextToken());
                    arr[i] |= (1 << x - 1);
                    break;
                }
                case 2 : {
                    int x = Integer.parseInt(st.nextToken());
                    arr[i] &= ~(1 << x - 1);
                    break;
                }
                case 3 : {
                    arr[i] <<= 1;
                    arr[i] &= ~(1 << 20);
                    break;
                }
                case 4 : {
                    arr[i] >>= 1;
                    break;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (set.add(arr[i])) result++;
        }
        System.out.println(result);
    }
}