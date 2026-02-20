import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] aToB = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) aToB[i] = Integer.parseInt(st.nextToken());

        int[] bToA = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) bToA[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(aToB);
        Arrays.sort(bToA);

        long aOutlet = 1;
        long bOutlet = 0;

        int aIdx = n - 1;
        int bIdx = m - 1;

        aOutlet--;
        bOutlet += aToB[aIdx--];

        while (bIdx >= 0) {
            if (bOutlet > 0) {
                bOutlet--;
                aOutlet += bToA[bIdx--];
            }
            
            else if (aIdx >= 0 && aOutlet > 0) {
                aOutlet--;
                bOutlet += aToB[aIdx--];
            }
            else {
                break;
            }
        }

        System.out.println(aOutlet);
    }
}