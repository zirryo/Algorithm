import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String road = scanner.next();
        int[] firstPosition = new int[26];
        int[] secondPosition = new int[26];
        Arrays.fill(firstPosition, -1);
        Arrays.fill(secondPosition, -1);

        for (int i = 0; i < 52; i++) {
            int cow = road.charAt(i) - 'A';
            if (firstPosition[cow] == -1) {
                firstPosition[cow] = i;
            } else {
                secondPosition[cow] = i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if ((firstPosition[i] < firstPosition[j] && firstPosition[j] < secondPosition[i] && secondPosition[i] < secondPosition[j])
                        || (firstPosition[j] < firstPosition[i] && firstPosition[i] < secondPosition[j] && secondPosition[j] < secondPosition[i])) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
