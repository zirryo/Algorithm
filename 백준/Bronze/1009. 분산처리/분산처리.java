import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 수

        // 각 숫자에 따른 반복 패턴
        int[][] pattern = {
            {},             // 0은 사용하지 않음
            {1},            // 1의 패턴
            {2, 4, 8, 6},   // 2의 패턴
            {3, 9, 7, 1},   // 3의 패턴
            {4, 6},         // 4의 패턴
            {5},            // 5의 패턴
            {6},            // 6의 패턴
            {7, 9, 3, 1},   // 7의 패턴
            {8, 4, 2, 6},   // 8의 패턴
            {9, 1}          // 9의 패턴
        };

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // a의 마지막 자리 숫자
            int lastDigit = a % 10;

            if (lastDigit == 0) {
                // 마지막 자리 숫자가 0인 경우
                System.out.println(10);
            } else {
                // 패턴 길이를 구해 반복적으로 처리
                int len = pattern[lastDigit].length;
                // b-1을 len으로 나눈 나머지를 구해 인덱스를 얻음
                int index = (b - 1) % len;
                // 해당 인덱스의 값을 출력
                System.out.println(pattern[lastDigit][index]);
            }
        }

        sc.close();
    }
}
