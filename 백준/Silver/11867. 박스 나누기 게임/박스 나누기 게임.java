import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N % 2 != 0 && M % 2 != 0) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}