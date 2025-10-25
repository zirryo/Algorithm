import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n < 206) System.out.println(1);
        else if (n < 218) System.out.println(2);
        else if (n < 229) System.out.println(3);
        else System.out.println(4);
    }
}