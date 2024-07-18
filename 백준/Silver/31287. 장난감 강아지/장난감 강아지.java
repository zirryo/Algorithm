import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] command = sc.next().toCharArray();
        boolean comeBackStartPoint = false;
        int[] currentPoint = {0, 0}; // 배열의 정중앙에서 시작

        Outer:
        for (int k = 0; k < Math.min(2000, K); k++) {
            for (char c : command) {
                switch (c) {
                    case 'U':
                        currentPoint[0]--;
                        break;
                    case 'D':
                        currentPoint[0]++;
                        break;
                    case 'L':
                        currentPoint[1]--;
                        break;
                    case 'R':
                        currentPoint[1]++;
                        break;
                }

                if (currentPoint[0] == 0 && currentPoint[1] == 0) {
                    comeBackStartPoint = true;
                    break Outer;
                }
            }
        }

        if (comeBackStartPoint) System.out.println("YES");
        else System.out.println("NO");
    }
}