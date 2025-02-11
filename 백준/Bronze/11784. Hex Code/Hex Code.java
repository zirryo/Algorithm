import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i += 2) {
                String hexPair = line.substring(i, i + 2);
                char decodedChar = (char) Integer.parseInt(hexPair, 16);
                sb.append(decodedChar);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
