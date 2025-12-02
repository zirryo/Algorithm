import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N == 1) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
