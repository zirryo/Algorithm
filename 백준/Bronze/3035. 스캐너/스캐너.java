import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int r = 0; r < ZR; r++) {
                for (int j = 0; j < C; j++) {
                    char ch = line.charAt(j);
                    for (int c = 0; c < ZC; c++) {
                        sb.append(ch);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}