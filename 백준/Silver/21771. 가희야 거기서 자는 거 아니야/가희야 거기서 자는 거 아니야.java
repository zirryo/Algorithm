import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Rg = Integer.parseInt(st.nextToken());
        int Cg = Integer.parseInt(st.nextToken());
        int Rp = Integer.parseInt(st.nextToken());
        int Cp = Integer.parseInt(st.nextToken());

        int pCount = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'P') {
                    pCount++;
                }
            }
        }

        int expectedPSize = Rp * Cp;

        if (pCount < expectedPSize) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}