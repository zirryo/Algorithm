import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            result += findNumberOfCases(s, k);
        }

        System.out.println(result);
    }
    private static int findNumberOfCases(String input, int len) {
        int emptySeat = 0, cases = 0;

        for (char seat : input.toCharArray()) {
            if (seat == '0') {
                emptySeat++;
            } else {
                cases += Math.max(emptySeat - len + 1, 0);
                emptySeat = 0;
            }
        }

        cases += Math.max(emptySeat - len + 1, 0);

        return cases;
    }

}