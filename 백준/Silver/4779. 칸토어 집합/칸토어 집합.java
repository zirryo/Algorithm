import java.util.Scanner;

class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n;
        StringBuilder result = new StringBuilder();
        while (sc.hasNext()) {
            n = sc.nextInt();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n + 1; i++) {
                if (i == 0) {
                    s.append("-");
                }
                else s.append(" ".repeat((int)Math.pow(3, i-1)) + s);
            }
            result.append(s).append("\n");
        }
        System.out.println(result);
    }
}