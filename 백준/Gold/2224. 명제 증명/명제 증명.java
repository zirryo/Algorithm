import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] dist = new boolean[52][52];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char p = line.charAt(0);
            char q = line.charAt(5);
            dist[charToIndex(p)][charToIndex(q)] = true;
        }

        // 52^3 = 140,608 번의 연산 수행
        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 52; j++) {
                    if (dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i != j && dist[i][j]) {
                    count++;
                    sb.append(indexToChar(i)).append(" => ").append(indexToChar(j)).append("\n");
                }
            }
        }

        System.out.println(count);
        System.out.print(sb);
    }

    static int charToIndex(char c) {
        if (c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }

    static char indexToChar(int i) {
        if (i < 26) return (char) (i + 'A');
        return (char) (i - 26 + 'a');
    }
}