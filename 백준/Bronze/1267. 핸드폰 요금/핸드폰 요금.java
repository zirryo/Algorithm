import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 통화 횟수
        int[] calls = new int[N];  // 통화 시간들
        
        for (int i = 0; i < N; i++) {
            calls[i] = sc.nextInt();
        }
        
        int Y_cost = 0;  // 영식 요금제 비용
        int M_cost = 0;  // 민식 요금제 비용
        
        for (int i = 0; i < N; i++) {
            Y_cost += (calls[i] / 30 + 1) * 10;
            M_cost += (calls[i] / 60 + 1) * 15;
        }
        
        if (Y_cost < M_cost) {
            System.out.println("Y " + Y_cost);
        } else if (M_cost < Y_cost) {
            System.out.println("M " + M_cost);
        } else {
            System.out.println("Y M " + Y_cost);  // 요금이 같을 때
        }
        
        sc.close();
    }
}
