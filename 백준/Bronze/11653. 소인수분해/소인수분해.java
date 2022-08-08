import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder divider = new StringBuilder();

        while(N % 2 == 0) {
            divider.append(2).append("\n");
            N = N/2;
        }
        for(int i=3; i<=Math.sqrt(N); i++) {
            while(N%i == 0) {
                divider.append(i).append("\n");
                N = N/i;
            }
        }
        if(N!=1) divider.append(N);
        System.out.println(divider);
    }
}