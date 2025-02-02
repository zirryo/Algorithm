import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = n * (n - 1) * (n - 2) * (n - 3) / 24;
        System.out.println(result);

        /* 하나의 대각선은 두 개의 꼭짓점을 이어서 만듦
        -> 교차점은 두 개의 대각선이 교차할 때 생성됨.
        -> 두 개의 교차점이 생기는 경우의 수 == 전체 꼭짓점 중에서 순서없이 꼭짓점을 4개 선택하는 경우의 수
         */

    }
}