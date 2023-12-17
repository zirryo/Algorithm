import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = N / 3;
        int M = N % 3;

        if ((K + M) % 2 == 0) System.out.println("SK");
        else System.out.println("CY");
    }
}