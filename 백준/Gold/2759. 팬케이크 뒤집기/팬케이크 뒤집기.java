import java.io.*;
import java.util.*;

public class Main {

    static void flip(int[] a, int k) {
        for (int i = 0; i < k / 2; i++) {
            int tmp = a[i];
            a[i] = a[k - 1 - i];
            a[k - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> filpList = new ArrayList<>();

            for (int size = N; size >= 2; size--) {
                int pos = -1;
                for (int i = 0; i < size; i++) {
                    if (a[i] == size) {
                        pos = i;
                        break;
                    }
                }

                if (pos == size - 1) continue;

                if (pos > 0) {
                    flip(a, pos + 1);
                    filpList.add(pos + 1);
                }

                flip(a, size);
                filpList.add(size);
            }

            sb.append(filpList.size());
            for (int k : filpList) sb.append(" ").append(k);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
