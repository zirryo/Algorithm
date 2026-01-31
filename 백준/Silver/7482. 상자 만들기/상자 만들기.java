import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (sc.hasNextDouble()) {
                    double a = sc.nextDouble();
                    double b = a / 6.0;
                    
                    System.out.printf("%.10f\n", b);
                }
            }
        }
        sc.close();
    }
}

/* 미분을 활용한 높이 b 찾기
- 상자 한 변의 길이 = a - 2b
- 상자의 부피 V(b) = (a - 2b)^2 * b = 4b^3 - 4ab^2 + a^2b, (b>0, a-2b>0)
- b에 대해 미분 V'(b) = 12b^2 - 8ab + a^2, (6b-a)(2b-a) = 0
- 부피를 최대로 만드는 b = a/6
 */