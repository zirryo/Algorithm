import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int chickenCount = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'C') chickenCount++;
        }

        int low = 1;
        int high = chickenCount;
        int answer = chickenCount;

        while (low <= high) {
            int mid = (low + high) / 2;
            int neededSlots = (chickenCount + mid - 1) / mid - 1;
            int nonChicken = N - chickenCount;

            if (neededSlots <= nonChicken) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
