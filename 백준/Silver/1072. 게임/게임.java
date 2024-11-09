import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);

        long Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }


        long left = 1;
        long right = X;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);


        /* <right = X 인 이유>

        - 최악의 경우 (이미 승률이 99프로에 가까운 경우) 승률을 단 1%을 올리기 위해 매우 많은 추가 승리가 필요함.
        - 승률 계산이 현재까지의 승리 횟수와 경기 수에 비례하기 때문임.
        - 현재 승률이 높을수록 더 많은 승리가 필요한데 99%에서 100%에 도달하려면 남은 경기를 모두 이겨야함.
            -> 즉, 최악의 경우 필요한 추가 승리의 수는 X에 수렴함.
         */
    }
}
