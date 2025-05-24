import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] s = new String[6];
            String line = br.readLine();
            String line2 = br.readLine().replace("...", "");

            int firstOpen = line.indexOf('<');
            int firstClose = line.indexOf('>');
            int secondOpen = line.indexOf('<', firstOpen + 1);
            int secondClose = line.indexOf('>', secondOpen + 1);

            s[1] = line.substring(0, firstOpen);
            s[2] = line.substring(firstOpen + 1, firstClose);
            s[3] = line.substring(firstClose + 1, secondOpen);
            s[4] = line.substring(secondOpen + 1, secondClose);
            s[5] = line.substring(secondClose + 1);

            sb.append(s[1] + s[2] + s[3] + s[4] + s[5] + "\n");
            sb.append(line2 + s[4] + s[3] + s[2] + s[5] + "\n");
        }

        System.out.println(sb);
    }
}