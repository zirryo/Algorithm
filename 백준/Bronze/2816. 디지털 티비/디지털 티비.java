import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] channels = new String[N];
        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < N; i++) {
            channels[i] = br.readLine();
            if (channels[i].equals("KBS1")) {
                pos1 = i;
            }

            if (channels[i].equals("KBS2")) {
                pos2 = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pos1; i++) sb.append('1');
        for (int i = 0; i < pos1; i++) sb.append('4');


        if (pos1 < pos2) {
            for (int i = 0; i < pos2; i++) sb.append('1');
            for (int i = 0; i < pos2 - 1; i++) sb.append('4');
        } else {
            for (int i = 0; i <= pos2; i++) sb.append('1');
            for (int i = 0; i < pos2; i++) sb.append('4');
        }


        System.out.println(sb);
    }
}
