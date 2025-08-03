import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> operations = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (A[i] == i + 1) continue;


            int target = i + 1;
            int j = i;
            while (j < N && A[j] != target) {
                j++;
            }

            if (j == N) {
                System.out.println(-1);
                return;
            }

            reverse(A, i, j);
            operations.add(new int[]{i + 1, j + 1});

            if (operations.size() > LIMIT) {
                System.out.println(-1);
                return;
            }
        }
        
        sb.append(operations.size()).append("\n");
        for (int[] op : operations) {
            sb.append(op[0]).append(" ").append(op[1]).append("\n");
        }

        System.out.print(sb);
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
