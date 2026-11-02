import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String row = "*".repeat(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(row).append("\n");
        }

        System.out.print(sb.toString());
    }
}