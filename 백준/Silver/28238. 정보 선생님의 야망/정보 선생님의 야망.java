import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int bit = Integer.parseInt(st.nextToken());
                arr[i] += bit * (1 << (4 - j));
            }
        }

        int result = 0;
        int day = 0;

        for (int i = 0; i < (1 << 5); i++) {
            if (Integer.bitCount(i) != 2) continue;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & arr[j]) == i) {
                    sum++;
                }
            }
            if (sum > result) {
                result = sum;
                day = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");

        if (result == 0) {
            sb.append("0 0 0 1 1");
        } else {
            for (int i = 4; i >= 0; i--) {
                sb.append((day >> i) & 1).append(" ");
            }
        }

        System.out.println(sb);
    }
}