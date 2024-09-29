import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String board = br.readLine();

        int len = board.length();
        int i = 0;

        while (i < len) {
            if (board.charAt(i) == '.') {
                sb.append('.');
                i++;
            } else {
                int countX = 0;

                while (i < len && board.charAt(i) == 'X') {
                    countX++;
                    i++;
                }

                while (countX >= 4) {
                    sb.append("AAAA");
                    countX -= 4;
                }

                if (countX == 2) {
                    sb.append("BB");
                } else if (countX != 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(sb);
    }
}
