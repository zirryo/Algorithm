import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int groupNum = 1;

        while (N != 0) {
            String[] names = new String[N];
            String[][] values = new String[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                names[i] = st.nextToken();
                for (int j = 1; j < N; j++) {
                    values[i][j] = st.nextToken();
                }
            }

            boolean nasty = false;
            sb.append("Group ").append(groupNum++).append("\n");

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (values[i][j].equals("N")) {
                        nasty = true;
                        int idx = (i + (N - j)) % N;
                        sb.append(names[idx]).append(" was nasty about ").append(names[i]).append("\n");
                    }
                }
            }

            if (!nasty) {
                sb.append("Nobody was nasty\n");
            }
            N = Integer.parseInt(br.readLine());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
