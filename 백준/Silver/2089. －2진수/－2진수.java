import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                int r = n % (-2);
                n /= -2;

                if (r < 0) {
                    r *= -1;
                    n++;
                }
                sb.append(r);
            }
            System.out.println(sb.reverse());
        }
    }
}