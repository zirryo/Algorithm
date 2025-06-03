import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int holderCount = 1;
        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == 'S') {
                holderCount++;
            } else if (seats.charAt(i) == 'L') {
                holderCount++;
                i++;
            }
        }

        System.out.println(Math.min(n, holderCount));
    }
}
