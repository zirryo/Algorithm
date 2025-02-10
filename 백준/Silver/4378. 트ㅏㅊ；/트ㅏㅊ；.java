import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

        String line;
        while ((line = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();

            for (char ch : line.toCharArray()) {
                if (ch == ' ') {
                    sb.append(' ');
                } else {
                    int idx = keyboard.indexOf(ch);
                    if (idx > 0) {
                        sb.append(keyboard.charAt(idx - 1));
                    }
                }
            }

            System.out.println(sb);
        }
    }
}
