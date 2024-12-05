import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int a1 = Integer.parseInt(line1[0]);
        int a0 = Integer.parseInt(line1[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if (a1 > c) {
            System.out.println(0);
        } else {
            if (a1 * n0 + a0 <= c * n0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
