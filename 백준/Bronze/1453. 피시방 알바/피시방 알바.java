import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] seats = new boolean[101]; 
        int rejected = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int seat = Integer.parseInt(st.nextToken());
            if (seats[seat]) {
                rejected++; 
            } else {
                seats[seat] = true; 
            }
        }

        System.out.println(rejected);
    }
}
