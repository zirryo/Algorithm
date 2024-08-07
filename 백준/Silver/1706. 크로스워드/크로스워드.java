import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        Set<String> crossWords = new TreeSet<>();
        StringBuilder sb;

        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '#') {
                    if (sb.length() > 1) {
                        crossWords.add(sb.toString());
                    }
                    if (sb.length() > 0) {
                        sb = new StringBuilder();
                    }

                } else {
                    sb.append(board[i][j]);
                }
            }
            if (sb.length() > 1) crossWords.add(sb.toString());
        }

        for (int j = 0; j < M; j++) {
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (board[i][j] == '#') {
                    if (sb.length() > 1) {
                        crossWords.add(sb.toString());
                    } else if (sb.length() == 1) {
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(board[i][j]);
                }
            }
            if (sb.length() > 1) crossWords.add(sb.toString());
        }

        System.out.println(crossWords.stream().min(Comparator.naturalOrder()).orElse(""));

    }
}