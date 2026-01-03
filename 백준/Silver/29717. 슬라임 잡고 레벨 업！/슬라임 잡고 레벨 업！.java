import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            long totalExp = N * (N + 1) / 2;

            long low = 1;
            long high = 2000000000L;
            long ans = 1;

            while (low <= high) {
                long mid = (low + high) / 2;
                if (checkLev(mid, totalExp)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static boolean checkLev(long L, long totalExp) {
        if (L == 1) return true;

        long required = L * (L - 1);
        return required <= totalExp;
    }
}