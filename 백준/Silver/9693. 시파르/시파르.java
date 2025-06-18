import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            long count = 0;
            long divisor = 5;

            while (divisor <= N) {
                count += N / divisor;
                divisor *= 5;
            }

            sb.append("Case #" + caseNum + ": " + count + "\n");
            caseNum++;
        }

        System.out.println(sb);
    }
}
