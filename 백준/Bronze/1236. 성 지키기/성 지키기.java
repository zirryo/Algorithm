import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] castle = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            castle[i] = line.toCharArray();
        }

        int emptyRow = 0;
        for (int i = 0; i < N; i++) {
            boolean guard = false;
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    guard = true;
                    break;
                }
            }
            if (!guard) emptyRow++;
        }

        int emptyCol = 0;
        for (int j = 0; j < M; j++) {
            boolean guard = false;
            for (int i = 0; i < N; i++) {
                if (castle[i][j] == 'X') {
                    guard = true;
                    break;
                }
            }
            if (!guard) emptyCol++;
        }

        System.out.println(Math.max(emptyRow, emptyCol));
    }
}
