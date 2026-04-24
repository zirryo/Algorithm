import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int T = sc.nextInt();

        for (int x = 1; x <= T; x++) {
            int N = sc.nextInt();
            
            // 0인 경우 영원히 잠들 수 없음
            if (N == 0) {
                System.out.println("Case #" + x + ": INSOMNIA");
                continue;
            }

            boolean[] visited = new boolean[10];
            int count = 0; // 발견한 서로 다른 숫자의 개수
            int i = 1;
            long currentN = 0;

            while (count < 10) {
                currentN = (long) N * i;
                long temp = currentN;

                while (temp > 0) {
                    int digit = (int) (temp % 10);
                    if (!visited[digit]) {
                        visited[digit] = true;
                        count++;
                    }
                    temp /= 10;
                }
                
                if (currentN == 0 && !visited[0]) {
                    visited[0] = true;
                    count++;
                }

                if (count == 10) break;
                i++;
            }

            System.out.println("Case #" + x + ": " + currentN);
        }
        sc.close();
    }
}